package com.example.integrador.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;

    @ManyToOne
    private Cliente cliente;


    private String descripcionProblema;
    private String tipoProblema;

    @ManyToOne
    private Tecnico tecnicoAsignado;

    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaResolucion;

    private String estado;
    private String consideracionesResolucion;

}
