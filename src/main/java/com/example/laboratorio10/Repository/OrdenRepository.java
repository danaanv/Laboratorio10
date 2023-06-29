package com.example.laboratorio10.Repository;

import com.example.laboratorio10.Entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {
}