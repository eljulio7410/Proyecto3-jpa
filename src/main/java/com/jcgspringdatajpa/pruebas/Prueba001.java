package com.jcgspringdatajpa.pruebas;

import com.jcgspringdatajpa.entities.entity1.Direccion;
import com.jcgspringdatajpa.entities.entity1.Estudiante;
import com.jcgspringdatajpa.repositories.repository1.DireccionRepository;
import com.jcgspringdatajpa.repositories.repository1.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class Prueba001 implements CommandLineRunner {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public void run(String... args) throws Exception{
        Direccion direccion = new Direccion();
        direccion.setCalle("54 calle principal");
        direccion.setCiudad("Ciudad ejemplo 4");
        direccion.setCodigoPostal("12");

        //direccionRepository.save(direccion);

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Mario");
        estudiante.setDireccion(direccion);

        estudianteRepository.save(estudiante);

        estudiante.setNombre("Mario actualizado");
        estudianteRepository.save(estudiante);

        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        for (Estudiante e: estudiantes){
            System.out.printf("Estudiante : " + e.getNombre() + ", Direccion : " + e.getDireccion().getCalle());
        }
        estudianteRepository.delete(estudiante);
    }
}
