package com.jcgspringdatajpa.pruebas;

import com.jcgspringdatajpa.entities.entity6.Aerolinea;
import com.jcgspringdatajpa.entities.entity6.Vuelo;
import com.jcgspringdatajpa.repositories.repository6.AerolineaRepository;
import com.jcgspringdatajpa.repositories.repository6.VueloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class Prueba006 implements CommandLineRunner {

    private final AerolineaRepository aerolineaRepository;

    private final VueloRepository vueloRepository;

    public Prueba006(AerolineaRepository aerolineaRepository, VueloRepository vueloRepository) {
        this.aerolineaRepository = aerolineaRepository;
        this.vueloRepository = vueloRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre("Aeroñinea avianca");

        Vuelo vuelo1 = new Vuelo();
        vuelo1.setNumeroVuelo("cs41");
        vuelo1.setDestino("Ciudad de Mexico");

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setNumeroVuelo("rps45");
        vuelo2.setDestino("Ciudad Bogota");

        aerolinea.getVuelos().add(vuelo1);
        aerolinea.getVuelos().add(vuelo2);

        aerolineaRepository.save(aerolinea);

        Aerolinea aerolineaDesdeBd = aerolineaRepository.findById(aerolinea.getId()).orElse(null);
        System.out.println("Aerolinea : " + aerolineaDesdeBd.getNombre());

        aerolineaRepository.delete(aerolineaDesdeBd);

        List<Vuelo> vuelos = vueloRepository.findAll();
        System.out.println("Numero de vuelos en la base de datos : " + vuelos.size());
    }
}
