package com.jcgspringdatajpa.entities.entity5;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Jugador {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private int numeroCamiseta;

    @ManyToOne
    @JoinColumn(name = "equipo-id")
    private Equipo equipo;

}
