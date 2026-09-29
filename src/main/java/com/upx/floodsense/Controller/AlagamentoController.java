package com.upx.floodsense.Controller;

import com.upx.floodsense.Model.Alagamento;
import com.upx.floodsense.Repositories.AlagamentoRepository;
import com.upx.floodsense.Service.AlagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/alagamentos_ativos")

public class AlagamentoController {
    @Autowired
    AlagamentoRepository repository;

    private final AlagamentoService alagamentoService;

    public AlagamentoController(AlagamentoService alagamentoService){
        this.alagamentoService = alagamentoService;
    }

    @GetMapping("/alagamentos_ativos")
    public ResponseEntity<List<Alagamento>> getAlagamentosAtivos(){
        List<Alagamento> listAlagamentosAtivos = alagamentoService.getAlagamentosAtivos();
        return ResponseEntity.status(HttpStatus.OK).body(listAlagamentosAtivos);
    }

    @GetMapping("/alagamentos_historico")
    public ResponseEntity<List<Alagamento>> getAlagamentosHistorico(){
        List<Alagamento> listAlagamentosHistorico = alagamentoService.getAlagamentosHistory();
        return ResponseEntity.status(HttpStatus.OK).body(listAlagamentosHistorico);
    }

    @PostMapping("/new_alagamento")
    public ResponseEntity<Alagamento> newAlagamento(@RequestBody CreateAlagamentoDTO createAlagamentoDTO){
        var newAlagamento = alagamentoService.createAlagamento(createAlagamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAlagamento);
    }

    @PostMapping("/reset_alagamento/{fkCodigoBueiro}")
    public ResponseEntity<String> resetAlagamento(@PathVariable String fkCodigoBueiro){
        var resetAlagamento = alagamentoService.resetAlagamento(fkCodigoBueiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(fkCodigoBueiro);
    }

}
