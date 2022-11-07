package com.controledejornada.registrodeponto.model.dtos.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoListar;

public class UsuarioDtoRegistros implements Serializable {

    private int id;
    private String username;
    private Integer pessoaId;
    private List<RegistroDtoListar> registros = new ArrayList<>();

    public UsuarioDtoRegistros() {
    }

    public UsuarioDtoRegistros(Usuario usuario) {
        id = usuario.getId();
        username = usuario.getUsername();
        pessoaId = usuario.getPessoa().getId();
        registros = usuario.getRegistros().stream().map(r -> new RegistroDtoListar(r)).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public List<RegistroDtoListar> getRegistros() {
        return registros;
    }
}
