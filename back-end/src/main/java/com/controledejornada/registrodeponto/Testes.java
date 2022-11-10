package com.controledejornada.registrodeponto;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.repository.JornadaRepository;
import com.controledejornada.registrodeponto.repository.PessoaRepository;
import com.controledejornada.registrodeponto.repository.UsuarioRepository;

@Configuration
public class Testes implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JornadaRepository jornadaRepository;

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa("André", "01234567890", LocalDate.of(2000, 1, 20), "andre@gmail.com");
        Usuario u1 = new Usuario(p1, "andreldc", "suporte");
        Pessoa p2 = new Pessoa("Marilia", "990876654433", LocalDate.of(1998, 7, 30), "marilia@gmail.com");
        Usuario u2 = new Usuario(p2, "mariliafc", "teste");

        pessoaRepository.saveAll(Arrays.asList(p1, p2));
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        Jornada j1 = new Jornada(LocalDate.of(2022, 11, 1), u1);
        Jornada j2 = new Jornada(LocalDate.of(2022, 11, 2), u1);
        Jornada j3 = new Jornada(LocalDate.of(2022, 11, 3), u1);
        Jornada j4 = new Jornada(LocalDate.of(2022, 11, 4), u1);

        // u1.addJornada(j1);
        // u1.addJornada(j2);
        // u1.addJornada(j3);
        // u1.addJornada(j4);

        jornadaRepository.saveAll(Arrays.asList(j1, j2, j3, j4));

        // List<Registro> registros = registroRepository.findByUsuario(u1.getId());

        // for (Registro r : registros) {
        // System.out.println(r.getHorarioRegistro() + ", usuário: " +
        // r.getUsuario().getId());
        // }
    }

}
