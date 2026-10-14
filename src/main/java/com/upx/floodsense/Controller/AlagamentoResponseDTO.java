package com.upx.floodsense.Controller;

import java.sql.Timestamp;

public record AlagamentoResponseDTO(
        Long id,
        Timestamp inicio,
        Timestamp fim,
        String status,
        String codigoDispositivo,
        String latitude,
        String longitude
) {}