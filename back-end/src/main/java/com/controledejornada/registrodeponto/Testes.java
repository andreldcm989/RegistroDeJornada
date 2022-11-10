package com.controledejornada.registrodeponto;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.repository.PessoaRepository;
import com.controledejornada.registrodeponto.repository.UsuarioRepository;

@Configuration
public class Testes implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa("André", "01234567890", LocalDate.of(2000, 1, 20), "andre@gmail.com");
        Usuario u1 = new Usuario(p1, "andreldc", "suporte");
        Pessoa p2 = new Pessoa("Marilia", "990876654433", LocalDate.of(1998, 7, 30), "marilia@gmail.com");
        Usuario u2 = new Usuario(p2, "mariliafc", "teste");

        pessoaRepository.saveAll(Arrays.asList(p1, p2));
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        // List<Registro> registros = registroRepository.findByUsuario(u1.getId());

        // for (Registro r : registros) {
        // System.out.println(r.getHorarioRegistro() + ", usuário: " +
        // r.getUsuario().getId());
        // }
    }

}
