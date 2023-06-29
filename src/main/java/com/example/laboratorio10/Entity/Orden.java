package com.example.laboratorio10.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorden", nullable = false)
    private Integer id;

    @Column(name = "columnas", nullable = false)
    private Integer columnas;

    @Column(name = "filas", nullable = false)
    private Integer filas;
}
