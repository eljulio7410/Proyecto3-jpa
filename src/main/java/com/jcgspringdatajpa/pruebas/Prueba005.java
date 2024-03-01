package com.jcgspringdatajpa.pruebas;


import com.jcgspringdatajpa.entities.entity5.Equipo;
import com.jcgspringdatajpa.entities.entity5.Jugador;
import com.jcgspringdatajpa.repositories.repository5.EquipoRepository;
import com.jcgspringdatajpa.repositories.repository5.JugadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Transactional
public class Prueba005 implements CommandLineRunner {

    private final EquipoRepository equipoRepository;

    private final JugadorRepository jugadorRepository;

    public Prueba005(EquipoRepository equipoRepository, JugadorRepository jugadorRepository) {
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo de futbol");

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Juan Perez");
        jugador1.setNumeroCamiseta(10);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Cristian Ramirez");
        jugador2.setNumeroCamiseta(7);

        equipo.getJugadores().add(jugador1);
        equipo.getJugadores().add(jugador2);

        equipoRepository.save(equipo);

        Equipo equipoGuardado = equipoRepository.findById(equipo.getId()).orElse(null);
        if (equipoGuardado !=null){
            System.out.println("Equipo : " + equipoGuardado.getNombre());
            System.out.println("Jugadores en el equipo (suando LAZY)");
            for (Jugador jugador : equipo.getJugadores()){
                System.out.println("-" + jugador.getNombre() + "(Camiseta #" + jugador.getNumeroCamiseta() + ")");
            }
        }

        if (equipoGuardado != null){
            Jugador jugadorActualizado = equipoGuardado.getJugadores().get(0);
            jugadorActualizado.setNumeroCamiseta(12);

            Equipo equipoActualizado = equipoRepository.findById(equipo.getId()).orElse(null);
            if(equipoActualizado != null){
                System.out.println("Equipo actualizado : " + equipoActualizado.getNombre());
                System.out.println("Jugadores actualizados : ");
                for (Jugador jugador : equipo.getJugadores()){
                    System.out.println("-" + jugador.getNombre() + jugador.getNombre() + "(Camiseta #" + jugador.getNumeroCamiseta() + ")");
                }

                equipoActualizado.getJugadores().remove(1);
                equipoRepository.delete(equipoActualizado);
            }
        }

        Equipo equipoEliminado = equipoRepository.findById(equipo.getId()).orElse(null);
        if (equipoEliminado == null){
            System.out.println("Equipo eliminado con exito");
        }
    }
}
