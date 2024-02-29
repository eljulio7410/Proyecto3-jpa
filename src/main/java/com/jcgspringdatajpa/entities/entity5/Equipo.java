package com.jcgspringdatajpa.entities.entity5;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Equipo {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "equipo",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<Jugador> jugadores = new ArrayList<>();
}
