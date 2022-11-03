package com.controledejornada.registrodeponto.model.dtos.usuario;

import java.io.Serializable;

import com.controledejornada.registrodeponto.model.Usuario;

public class UsuarioDtoSalvar implements Serializable {

    private String username;
    private String senha;

    public UsuarioDtoSalvar() {
    }

    public UsuarioDtoSalvar(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public UsuarioDtoSalvar(Usuario usuario) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

}
