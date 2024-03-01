package com.jcgspringdatajpa.pruebas;

import com.jcgspringdatajpa.entities.entity7.Alumno;
import com.jcgspringdatajpa.entities.entity7.Curso;
import com.jcgspringdatajpa.repositories.repository7.AlumnoRepository;
import com.jcgspringdatajpa.repositories.repository7.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Prueba007 implements CommandLineRunner {


    private final AlumnoRepository alumnoRepository;

    private final CursoRepository cursoRepository;

    public Prueba007(AlumnoRepository alumnoRepository, CursoRepository cursoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Juan");

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("ana");

        Curso curso1 = new Curso();
        curso1.setNombre("Matematicas");

        Curso curso2 = new Curso();
        curso2.setNombre("Historia");

        alumno1.getCursos().add(curso1);
        alumno2.getCursos().add(curso2);

        alumno2.getCursos().add(curso1);

        alumnoRepository.save(alumno1);
        alumnoRepository.save(alumno2);

        Alumno alumnoRecuperado = alumnoRepository.findById(1L).orElse(null);
        System.out.println("Alumno recuperado : " + alumnoRecuperado.getNombre());

        Curso cursoRecuperado = cursoRepository.findById(1L).orElse(null);
        System.out.println("Curso recuperado : " + cursoRecuperado.getNombre());



    }
}
