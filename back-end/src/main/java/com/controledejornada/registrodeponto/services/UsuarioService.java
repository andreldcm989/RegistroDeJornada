package com.controledejornada.registrodeponto.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoEditar;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoListar;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoRegistros;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoSalvar;
import com.controledejornada.registrodeponto.repository.UsuarioRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDtoListar> buscarUsuarios() {
        List<UsuarioDtoListar> dto = usuarioRepository.findAll().stream().map(u -> new UsuarioDtoListar(u))
                .collect(Collectors.toList());
        return dto;
    }

    public UsuarioDtoRegistros buscarUsuarioPorPessoa(int pessoaId) {
        Usuario usuario = usuarioRepository.findByPessoaId(pessoaId)
                .orElseThrow(() -> new ResourceNotFoundException(pessoaId));
        return new UsuarioDtoRegistros(usuario);
    }

    public UsuarioDtoRegistros buscarUsuarioPorId(int id) {
        Usuario u = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UsuarioDtoRegistros(u);
    }

    @Transactional
    public UsuarioDtoListar editarUsuario(int id, UsuarioDtoEditar usuario) {
        if (usuarioRepository.existsById(id)) {
            Usuario u = usuarioRepository.getReferenceById(id);
            u.setUsername(usuario.getUsername());
            usuarioRepository.save(u);
            return new UsuarioDtoListar(u);
        }
        throw new ResourceNotFoundException(id);
    }

    @Transactional
    public UsuarioDtoListar salvarUsuario(Pessoa pessoa, UsuarioDtoSalvar usuario) {
        Usuario u = new Usuario(pessoa, usuario);
        usuarioRepository.save(u);
        return new UsuarioDtoListar(u);
    }

    @Transactional
    public void excluirUsuario(int id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
