package com.upx.floodsense.Repositories;

import com.upx.floodsense.Model.Bueiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BueiroRepository extends JpaRepository<Bueiro, String> {
    Bueiro findByCodigoDispositivo(String s);
}
