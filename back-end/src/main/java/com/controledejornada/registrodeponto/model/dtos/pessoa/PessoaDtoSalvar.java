package com.controledejornada.registrodeponto.model.dtos.pessoa;

import java.io.Serializable;
import java.time.LocalDate;

import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoSalvar;

public class PessoaDtoSalvar implements Serializable {

    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String email;
    private UsuarioDtoSalvar usuario;

    public PessoaDtoSalvar() {
    }

    public PessoaDtoSalvar(String nome, String cpf, LocalDate nascimento, String email, UsuarioDtoSalvar usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.email = email;
        this.usuario = usuario;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
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

    public UsuarioDtoSalvar getUsuario() {
        return usuario;
    }
}
