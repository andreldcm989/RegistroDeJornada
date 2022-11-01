package com.controledejornada.registrodeponto.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.dtos.PessoaDto;
import com.controledejornada.registrodeponto.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<PessoaDto> listarPessoas() {
        List<Pessoa> pessoas = repository.findAll();
        List<PessoaDto> dto = pessoas.stream().map(p -> new PessoaDto(p)).collect(Collectors.toList());
        return dto;
    }

    public Pessoa buscarPessoaPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe pessoa com este id na base de dados."));
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public PessoaDto editarPessoa(int id, PessoaDto pessoa) {
        Pessoa p = repository.getReferenceById(id);
        p.setNome(pessoa.getNome());
        p.setCpf(pessoa.getCpf());
        p.setEmail(pessoa.getEmail());
        repository.save(p);
        PessoaDto dto = new PessoaDto(p);
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
