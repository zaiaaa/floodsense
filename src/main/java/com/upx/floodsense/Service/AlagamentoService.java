package com.upx.floodsense.Service;

import com.upx.floodsense.Model.Alagamento;
import com.upx.floodsense.Repositories.AlagamentoRepository;
import org.springframework.stereotype.Service;

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

}
