package com.controledejornada.registrodeponto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "td_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    private String username;
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Registro> registros = new ArrayList<>();

    public Usuario(Pessoa pessoa, String username, String senha) {
        this.pessoa = pessoa;
        this.username = username;
        this.senha = senha;
    }

    public int getId() {
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

    public void excluirPonto(Registro registro) {
        registros.remove(registro);
    }

}
