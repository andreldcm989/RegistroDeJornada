package com.controledejornada.registrodeponto.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listarPessoas() {
        return repository.findAll();
    }

    public Pessoa buscarPessoaPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe pessoa com este id na base de dados."));
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa editarPessoa(int id, Pessoa pessoa) {
        Pessoa p = repository.getReferenceById(id);
        p.setNome(pessoa.getNome());
        p.setCpf(pessoa.getCpf());
        p.setEmail(pessoa.getEmail());
        repository.save(p);
        return p;
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
