package com.controledejornada.registrodeponto.model.dtos.registro;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.controledejornada.registrodeponto.model.Registro;

public class RegistroDtoListar implements Serializable {

    private Integer id;
    private LocalDateTime horarioRegistro;
    private String tipoRegistro;

    public RegistroDtoListar() {
    }

    public RegistroDtoListar(Registro registro) {
        this.id = registro.getId();
        this.horarioRegistro = registro.getHorarioRegistro();
        this.tipoRegistro = registro.getTipoRegistro();
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getHorarioRegistro() {
        return horarioRegistro;
    }

    public void setHorarioRegistro(LocalDateTime horarioRegistro) {
        this.horarioRegistro = horarioRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

}
