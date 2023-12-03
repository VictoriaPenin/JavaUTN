package com.example.integrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tecnicos")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTecnico;
    private String nombre;
    @ElementCollection
    private List<String> servicios;
    private String cuitEmpleado;
    private String codSoporte;
    private String tituloTecnico;
    private String dispoTecnico;
    private final LocalDate altaTecnico = LocalDate.now();
    private String estadoTecnico;
    private String email;
    @ElementCollection
    private List<String> especialidades;
    private String tipoProblema;




}

