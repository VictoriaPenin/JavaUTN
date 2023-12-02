package com.example.integrador.repositories;

import com.example.integrador.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {
    List<Incidente> findByEstado(String asignado);
}
