package com.example.integrador.repositories;

import com.example.integrador.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Integer> {
}
