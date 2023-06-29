package com.example.laboratorio10.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "juego")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "contenttype")
    private String contentType;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "columnas")
    private String columnas;

    @Column(name = "filas")
    private String filas;
}
