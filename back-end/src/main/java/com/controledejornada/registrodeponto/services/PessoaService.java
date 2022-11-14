package com.controledejornada.registrodeponto.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoEditar;
import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoListar;
import com.controledejornada.registrodeponto.model.dtos.pessoa.PessoaDtoSalvar;
import com.controledejornada.registrodeponto.repository.PessoaRepository;
import com.controledejornada.registrodeponto.services.exceptions.ResourceNotFoundException;

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

    public PessoaDtoListar buscarPessoaPorId(int id) {
        return new PessoaDtoListar(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Transactional
    public PessoaDtoListar salvarPessoa(PessoaDtoSalvar pessoaDto) {
        Pessoa p = new Pessoa(pessoaDto);
        p.setUsuario(new Usuario(p, pessoaDto.getUsuario()));
        repository.save(p);
        PessoaDtoListar dto = new PessoaDtoListar(p);
        return dto;
    }

    @Transactional
    public PessoaDtoListar editarPessoa(int id, PessoaDtoEditar pessoa) {
        Pessoa p = repository.getReferenceById(id);
        BeanUtils.copyProperties(pessoa, p);
        repository.save(p);
        PessoaDtoListar dto = new PessoaDtoListar(p);
        return dto;
    }

    @Transactional
    public void excluirPessoa(int id) {
        try {
            usuarioService.excluirUsuario(repository.getReferenceById(id).getUsuario().getId());
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
