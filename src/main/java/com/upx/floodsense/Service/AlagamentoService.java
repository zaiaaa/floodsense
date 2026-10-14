package com.upx.floodsense.Service;

import com.upx.floodsense.Controller.AlagamentoResponseDTO;
import com.upx.floodsense.Controller.CreateAlagamentoDTO;
import com.upx.floodsense.Model.Alagamento;
import com.upx.floodsense.Model.Bueiro;
import com.upx.floodsense.Repositories.AlagamentoRepository;
import com.upx.floodsense.Repositories.BueiroRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class AlagamentoService {

    private final AlagamentoRepository alagamentoRepository;
    private final BueiroRepository bueiroRepository;

    public AlagamentoResponseDTO toDTO(Alagamento alagamento) {

        return new AlagamentoResponseDTO(
                alagamento.getId(),
                alagamento.getInicio(),
                alagamento.getFim(),
                alagamento.getStatus(),
                alagamento.getBueiro().getCodigoDispositivo(),
                alagamento.getBueiro().getLatitude(),
                alagamento.getBueiro().getLongitude()
        );
    }


    public AlagamentoService(AlagamentoRepository alagamentoRepository, BueiroRepository bueiroRepository) {
        this.alagamentoRepository = alagamentoRepository;
        this.bueiroRepository = bueiroRepository;
    }

    public List<AlagamentoResponseDTO> getAlagamentosAtivos(){
        return alagamentoRepository.findByStatus("ATIVO").stream().map(this::toDTO).toList();
    }

    public List<Alagamento> getAlagamentosHistory(){
        return alagamentoRepository.findAllByOrderByInicioDesc();
    }

    public Alagamento createAlagamento(
            CreateAlagamentoDTO createAlagamentoDTO) {

        var entity = new Alagamento();

        entity.setInicio(Timestamp.from(Instant.now()));
        entity.setStatus(createAlagamentoDTO.status());

        Bueiro bueiro = bueiroRepository.findByCodigoDispositivo(
                createAlagamentoDTO.fkCodigoDispositivo()
        );

        if (bueiro == null) {
            throw new RuntimeException(
                    "Bueiro não encontrado: "
                            + createAlagamentoDTO.fkCodigoDispositivo()
            );
        }

        entity.setBueiro(bueiro);

        return alagamentoRepository.save(entity);
    }

    public Alagamento resetAlagamento(String fkCodigoBueiro){
        var lastActiveFlood = alagamentoRepository.findFirstByBueiro_CodigoDispositivoAndStatusOrderByInicioDesc(fkCodigoBueiro, "ATIVO");
        if (lastActiveFlood.isEmpty()) {
            return null;
        }

        var entity = alagamentoRepository.findById(lastActiveFlood.get().getId()).orElseThrow();


        entity.setStatus("INATIVO");
        entity.setFim(Timestamp.from(Instant.now()));

        return alagamentoRepository.save(entity);
    }

}
