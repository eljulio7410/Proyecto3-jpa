package com.jcgspringdatajpa.pruebas;

import com.jcgspringdatajpa.entities.entity4.Automovil;
import com.jcgspringdatajpa.entities.entity4.Propietario;
import com.jcgspringdatajpa.repositories.repository4.AutomovilRepository;
import com.jcgspringdatajpa.repositories.repository4.PropietarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Prueba004 implements CommandLineRunner {

    private final PropietarioRepository propietarioRepository;

    private final AutomovilRepository automovilRepository;

    public Prueba004(PropietarioRepository propietarioRepository, AutomovilRepository automovilRepository) {
        this.propietarioRepository = propietarioRepository;
        this.automovilRepository = automovilRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Propietario propietario = new Propietario();
        propietario.setNombre("juan");

        Automovil automovil = new Automovil();
        automovil.setMarca("Toyota");
        automovil.setMarca("Camry");

        propietario.setAutomovil(automovil);
        automovil.setPropietario(propietario);

        propietarioRepository.save(propietario);
        automovilRepository.save(automovil);

        Long propietarioId = propietario.getId();
        Propietario propietarioLeido = propietarioRepository.findById(propietarioId).orElse(null);
        if(propietarioLeido != null){
            System.out.println("Propietario leido : " + propietarioLeido.getNombre());

            Automovil automovilUpdate = propietario.getAutomovil();
            automovilUpdate.setMarca("Honda");
            automovilUpdate.setModelo("Accord");
            automovilRepository.save(automovilUpdate);

            propietarioRepository.delete(propietario);

            Propietario propietarioDelete =propietarioRepository.findById(propietarioId).orElse(null);
            if (propietarioDelete == null){
                System.out.println("Propietario eliminado con exito !");
            }
        }
    }
}
