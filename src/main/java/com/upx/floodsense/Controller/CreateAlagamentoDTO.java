package com.upx.floodsense.Controller;

import java.sql.Timestamp;

public record CreateAlagamentoDTO(String fkCodigoDispositivo, Timestamp inicio, Timestamp fim, String status) {
}
