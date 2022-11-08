package com.controledejornada.registrodeponto.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Usuario;
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
        Usuario usuario = usuarioRepository.findUsuarioByPessoa(pessoaId)
                .orElseThrow(() -> new ResourceNotFoundException(pessoaId));
        return new UsuarioDtoRegistros(usuario);
    }

    public UsuarioDtoRegistros registrosDiarioPorUsuario(int idPessoa, String intervalo) {
        UsuarioDtoRegistros dto = buscarUsuarioPorPessoa(idPessoa);
        dto.setRegistros(dto.getRegistros().stream()
                .filter(r -> r.getHorarioRegistro().toLocalDate().isAfter(LocalDate.parse(intervalo)))
                .collect(Collectors.toList()));
        return dto;
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Object editarUsuario(Usuario usuario) {
        Usuario u = usuarioRepository.getReferenceById(usuario.getId());
        if (u != null) {
            BeanUtils.copyProperties(usuario, u);
            usuarioRepository.save(u);
            return u;
        }
        return "usuario não encontrado";
    }

    public UsuarioDtoListar salvarUsuario(Pessoa pessoa, UsuarioDtoSalvar usuario) {
        Usuario u = new Usuario(pessoa, usuario);
        usuarioRepository.save(u);
        return new UsuarioDtoListar(u);
    }
}
