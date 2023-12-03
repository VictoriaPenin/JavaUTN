package com.example.integrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIncidente;

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
    private int tiempoEstimado;
    private String servicio;

}
