package com.upx.floodsense.Repositories;

import com.upx.floodsense.Model.Alagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlagamentoRepository extends JpaRepository<Alagamento, Long> {

    List<Alagamento> findByStatus(String status);
    List<Alagamento> findAllByOrderByInicioDesc();

    Optional<Alagamento> findFirstByfkCodigoDispositivoAndStatusOrderByInicioDesc(
            String fkCodigoDispositivo,
            String status
    );


}
