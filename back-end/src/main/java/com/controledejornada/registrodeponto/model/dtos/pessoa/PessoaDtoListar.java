package com.controledejornada.registrodeponto.model.dtos.pessoa;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoListar;

public class PessoaDtoListar implements Serializable {

    private int id;
    private String nome;
    private String cpf;
    private String nascimento;
    private String email;
    private UsuarioDtoListar usuario;

    public PessoaDtoListar() {
    }

    public PessoaDtoListar(String nome, String cpf, String nascimento, String email, UsuarioDtoListar usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.email = email;
        this.usuario = usuario;
    }

    public PessoaDtoListar(Pessoa pessoa) {
        id = pessoa.getId();
        nome = pessoa.getNome();
        cpf = pessoa.getCpf();
        nascimento = pessoa.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        email = pessoa.getEmail();
        usuario = new UsuarioDtoListar(pessoa.getUsuario());
    }

    public int getId() {
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

    public UsuarioDtoListar getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDtoListar usuario) {
        this.usuario = usuario;
    }
}
