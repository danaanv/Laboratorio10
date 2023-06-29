package com.example.laboratorio10.Repository;

import com.example.laboratorio10.Entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}