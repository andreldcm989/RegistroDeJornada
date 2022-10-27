package com.controledejornada.registrodeponto.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Registro {

    private UUID id;
    private Usuario usuario;
    private LocalDateTime horarioRegistro;
    private String tipoRegistro;

    public Registro(Usuario usuario, LocalDateTime horarioRegistro, String tipoRegistro) {
        this.usuario = usuario;
        this.horarioRegistro = horarioRegistro;
        this.tipoRegistro = tipoRegistro;
    }

    public UUID getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getHorarioRegistro() {
        return horarioRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

}
