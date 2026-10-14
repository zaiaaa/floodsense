package com.upx.floodsense.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="dispositivos")
public class Bueiro {

    @Id
    @Column(name = "codigo_dispositivo")
    private String codigoDispositivo;

    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;

    public String getCodigoDispositivo() {
        return codigoDispositivo;
    }

    public void setCodigoDispositivo(String codigoDispositivo) {
        this.codigoDispositivo = codigoDispositivo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
