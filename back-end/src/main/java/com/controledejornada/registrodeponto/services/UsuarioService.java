package com.controledejornada.registrodeponto.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> buscarUsuarios() {
        return repository.findAll();
    }

    public Usuario buscarUsuarioPorPessoa(int pessoaId) {
        return repository.findUsuarioByPessoa(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado."));
    }

    public Usuario buscarUsuarioPorId(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado."));
    }

    public Object editarUsuario(Usuario usuario) {
        Usuario u = repository.getReferenceById(usuario.getId());
        if (u != null) {
            BeanUtils.copyProperties(usuario, u);
            repository.save(u);
            return u;
        }
        return "usuario não encontrado";
    }
}
