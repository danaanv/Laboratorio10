package com.example.laboratorio10.Repository;

import com.example.laboratorio10.Entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Integer> {
}