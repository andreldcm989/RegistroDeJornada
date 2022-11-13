package com.controledejornada.registrodeponto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.controledejornada.registrodeponto.model.Jornada;
import com.controledejornada.registrodeponto.model.Pessoa;
import com.controledejornada.registrodeponto.model.Registro;
import com.controledejornada.registrodeponto.model.Usuario;
import com.controledejornada.registrodeponto.model.dtos.registro.RegistroDtoSalvar;
import com.controledejornada.registrodeponto.repository.JornadaRepository;
import com.controledejornada.registrodeponto.repository.PessoaRepository;
import com.controledejornada.registrodeponto.repository.RegistroRepository;
import com.controledejornada.registrodeponto.repository.UsuarioRepository;

@Configuration
public class Testes implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JornadaRepository jornadaRepository;

    @Autowired
    private RegistroRepository registroRepository;

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

        jornadaRepository.saveAll(Arrays.asList(j1, j2, j3, j4));

        Registro r1 = new Registro(j1, LocalTime.of(8, 0, 0), "entrada");
        Registro r2 = new Registro(j1, LocalTime.of(12, 0, 0), "saida");
        Registro r3 = new Registro(j1, LocalTime.of(17, 0, 0), "saida");
        Registro r4 = new Registro(j1, LocalTime.of(13, 0, 0), "entrada");
        RegistroDtoSalvar r5 = new RegistroDtoSalvar(j1.getId(), LocalTime.of(18, 0,
                0), "entrada");

        registroRepository.saveAll(
                Arrays.asList(r4, r2, r1, r3, new Registro(j1, r5.getHorarioRegistro(),
                        r5.getTipoRegistro())));
        j1.addRegistro(r1);
        j1.addRegistro(r2);
        j1.addRegistro(r3);
        j1.addRegistro(r4);

        j1.calcularHorasTrabalhadas();
        jornadaRepository.save(j1);

        // List<Registro> registros = registroRepository.findByUsuario(u1.getId());

        // for (Registro r : registros) {
        // System.out.println(r.getHorarioRegistro() + ", usuário: " +
        // r.getUsuario().getId());
        // }
    }

}
