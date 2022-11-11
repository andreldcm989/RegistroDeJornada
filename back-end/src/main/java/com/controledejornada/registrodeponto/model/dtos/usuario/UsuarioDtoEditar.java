package com.controledejornada.registrodeponto.model.dtos.usuario;

import java.io.Serializable;

public class UsuarioDtoEditar implements Serializable {

    private String username;

    public UsuarioDtoEditar() {
    }

    public UsuarioDtoEditar(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
