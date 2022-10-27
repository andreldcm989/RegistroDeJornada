package com.controledejornada.registrodeponto.model;

import java.util.UUID;

public class Usuario {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String username;
    private String senha;

    public Usuario(String nome, String cpf, String email, String username, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.username = username;
        this.senha = senha;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
