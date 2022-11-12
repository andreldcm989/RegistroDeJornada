package com.controledejornada.registrodeponto.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoSalvar;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String email;

    @OneToOne(mappedBy = "pessoa")
    private Usuario usuario;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, LocalDate nascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Pessoa(PessoaDtoSalvar pessoa) {
        nome = pessoa.getNome();
        cpf = pessoa.getCpf();
        nascimento = pessoa.getNascimento();
        email = pessoa.getEmail();
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
