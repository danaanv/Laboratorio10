package com.example.laboratorio10.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "imagen", nullable = false)
    private byte[] imagen;

    @Column(name = "contenttype", nullable = false)
    private String contentType;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "juego_idjuego", nullable = false)
    private Juego juegoIdJuego;
}
