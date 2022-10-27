package com.controledejornada.registrodeponto.model;

import java.util.UUID;

public class Pessoa {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private Usuario usuario;

    public Pessoa(String nome, String cpf, String email, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.usuario = usuario;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
