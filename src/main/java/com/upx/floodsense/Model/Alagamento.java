package com.upx.floodsense.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "alagamentos")

public class Alagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "fk_codigo_dispositivo")
    private String fkCodigoDispositivo;

    @Column(name = "inicio")
    private Timestamp inicio;

    @Column(name="fim")
    private Timestamp fim;

    @Column(name="status")
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFkCodigoDispositivo() {
        return fkCodigoDispositivo;
    }

    public void setFkCodigoDispositivo(String fkCodigoDispositivo) {
        this.fkCodigoDispositivo = fkCodigoDispositivo;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public Timestamp getFim() {
        return fim;
    }

    public void setFim(Timestamp fim) {
        this.fim = fim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
