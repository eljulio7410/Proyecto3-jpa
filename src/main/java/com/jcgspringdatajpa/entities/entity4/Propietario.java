package com.jcgspringdatajpa.entities.entity4;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne (mappedBy = "propietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Automovil automovil;
}
