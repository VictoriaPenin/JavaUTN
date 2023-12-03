package com.example.integrador.repositories;

import com.example.integrador.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Integer> {


    List<Tecnico> findByServiciosContainingAndEspecialidadesIn(String servicio, List<String> strings);
}

