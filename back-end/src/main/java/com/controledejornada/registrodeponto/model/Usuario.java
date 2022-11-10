package com.controledejornada.registrodeponto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoSalvar;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    private String username;
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Jornada> jornadas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Pessoa pessoa, String username, String senha) {
        this.pessoa = pessoa;
        this.username = username;
        this.senha = senha;
    }

    public Usuario(Pessoa pessoa, UsuarioDtoSalvar usuarioDtoSalvar) {
        this.pessoa = pessoa;
        this.username = usuarioDtoSalvar.getUsername();
        this.senha = usuarioDtoSalvar.getSenha();
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

    public List<Jornada> getRegistros() {
        return jornadas;
    }

}
