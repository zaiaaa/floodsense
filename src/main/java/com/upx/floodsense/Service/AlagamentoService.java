package com.upx.floodsense.Service;

import com.upx.floodsense.Controller.CreateAlagamentoDTO;
import com.upx.floodsense.Model.Alagamento;
import com.upx.floodsense.Repositories.AlagamentoRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlagamentoService {

    private final AlagamentoRepository alagamentoRepository;

    public AlagamentoService(AlagamentoRepository alagamentoRepository) {this.alagamentoRepository = alagamentoRepository;}

    public List<Alagamento> getAlagamentosAtivos(){
        return alagamentoRepository.findByStatus("ATIVO");
    }

    public List<Alagamento> getAlagamentosHistory(){
        return alagamentoRepository.findAllByOrderByInicioDesc();
    }

    public Alagamento createAlagamento(CreateAlagamentoDTO createAlagamentoDTO){
        //DTO -> Entity

        var entity = new Alagamento();

        entity.setInicio(Timestamp.from(Instant.now()));
        entity.setStatus(createAlagamentoDTO.status());
        entity.setFkCodigoDispositivo(createAlagamentoDTO.fkCodigoDispositivo());

        return alagamentoRepository.save(entity);

    }

}
