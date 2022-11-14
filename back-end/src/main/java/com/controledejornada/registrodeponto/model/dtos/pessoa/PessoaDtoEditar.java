package com.controledejornada.registrodeponto.model.dtos.pessoa;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class PessoaDtoEditar implements Serializable {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String nascimento;
    @NotEmpty
    private String email;

    public PessoaDtoEditar() {
    }

    public PessoaDtoEditar(String nome, String cpf, String nascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.email = email;
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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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
}
