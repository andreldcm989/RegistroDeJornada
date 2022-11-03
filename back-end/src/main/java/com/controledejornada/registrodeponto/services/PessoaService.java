package com.controledejornada.registrodeponto.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoListar;
import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoSalvar;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoListar;
import com.controledejornada.registrodeponto.model.dtos.usuario.UsuarioDtoSalvar;
import com.controledejornada.registrodeponto.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    public List<PessoaDtoListar> listarPessoas() {
        List<Pessoa> pessoas = repository.findAll();
        List<PessoaDtoListar> dto = pessoas.stream().map(p -> new PessoaDtoListar(p)).collect(Collectors.toList());
        return dto;
    }

    public Pessoa buscarPessoaPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe pessoa com este id na base de dados."));
    }

    public PessoaDtoListar salvarPessoa(PessoaDtoSalvar pessoaDto) {
        Pessoa p = new Pessoa(pessoaDto);
        p.setUsuario(new Usuario(p, pessoaDto.getUsuario()));
        repository.save(p);
        UsuarioDtoListar usuario = usuarioService.salvarUsuario(p, pessoaDto.getUsuario());
        PessoaDtoListar dto = new PessoaDtoListar(p);
        dto.setUsuario(usuario);
        return dto;
    }

    public PessoaDtoListar editarPessoa(int id, PessoaDtoListar pessoa) {
        Pessoa p = repository.getReferenceById(id);
        BeanUtils.copyProperties(pessoa, p);
        repository.save(p);
        PessoaDtoListar dto = new PessoaDtoListar(p);
        return dto;
    }

    public Object excluirPessoa(int id) {
        Pessoa pessoa = buscarPessoaPorId(id);
        if (pessoa != null) {
            repository.deleteById(id);
            return "pessoa excluída com sucesso!";
        }
        return "erro ao excluir: usuário não encontrado";
    }

}
