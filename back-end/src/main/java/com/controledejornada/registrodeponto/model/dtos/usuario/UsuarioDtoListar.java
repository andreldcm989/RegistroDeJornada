package com.controledejornada.registrodeponto.model.dtos.usuario;

import java.io.Serializable;

import com.controledejornada.registrodeponto.model.Usuario;

public class UsuarioDtoListar implements Serializable {

    private int id;
    private String username;

    public UsuarioDtoListar() {
    }

    public UsuarioDtoListar(Usuario usuario) {
        id = usuario.getId();
        username = usuario.getUsername();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}
