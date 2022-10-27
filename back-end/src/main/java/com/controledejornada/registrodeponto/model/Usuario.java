package com.controledejornada.registrodeponto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {

    private UUID id;
    private Pessoa pessoa;
    private String username;
    private String senha;
    private List<Registro> registros = new ArrayList<>();

    public Usuario(Pessoa pessoa, String username, String senha) {
        this.pessoa = pessoa;
        this.username = username;
        this.senha = senha;
    }

    public UUID getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void registrarPonto(Registro registro) {
        registros.add(registro);
    }

}
