package com.controledejornada.registrodeponto.model.dtos;

import java.io.Serializable;

import com.controledejornada.registrodeponto.model.Pessoa;

public class PessoaDto implements Serializable {

    private String nome;
    private String cpf;
    private String email;
    private String usuario;

    public PessoaDto() {
    }

    public PessoaDto(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public PessoaDto(Pessoa pessoa) {
        nome = pessoa.getNome();
        cpf = pessoa.getCpf();
        email = pessoa.getEmail();
        usuario = pessoa.getUsuario().getUsername();
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
