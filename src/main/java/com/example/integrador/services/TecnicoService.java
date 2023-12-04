package com.example.integrador.services;

import com.example.integrador.model.Incidente;
import com.example.integrador.model.Tecnico;
import com.example.integrador.repositories.TecnicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Primary
@Lazy
public class TecnicoService  {

    @Autowired
    private TecnicoRepository tecnicoRepository;




    public List<Tecnico> obtenerTecnicosDisponibles(String servicio, String tipoProblema) {
        return tecnicoRepository.findByServiciosContainingAndEspecialidadesIn(servicio, Collections.singletonList(tipoProblema));
    }

    public int estimarTiempoResolucion(Tecnico tecnico, String tipoProblema) {
        int tiempoBase = 2; // tiempo base en horas
        int tiempoPorEspecialidad = contarEspecialidades(tecnico.getEspecialidades()); // cada especialidad suma una hora
        int tiempoPorProblema = obtenerTiempoPorProblema(tipoProblema); // obtiene el tiempo según el tipo de problema

        return tiempoBase + tiempoPorEspecialidad + tiempoPorProblema;
    }

    private int contarEspecialidades(List<String> especialidades) {
        int tiempoPorEspecialidad = 1; // Puedes ajustar según tus necesidades
        return especialidades.size() * tiempoPorEspecialidad;
    }


    public void enviarNotificacionNuevoIncidente(Tecnico tecnico, Incidente incidente) {
        System.out.println("Notificación al técnico " + tecnico.getNombre() + ": Nuevo incidente asignado - " +
                "ID del incidente: " + incidente.getIdIncidente());
    }

    public Tecnico altaTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public int calcularTiempoEstimado(boolean esComplejo, String tipoProblema) {

        int tiempoBase = 2; // tiempo base en horas
        int tiempoAdicional = esComplejo ? 3 : 0; // tiempo adicional si el problema es complejo

        return tiempoBase + tiempoAdicional + obtenerTiempoPorProblema(tipoProblema);
    }

    private int obtenerTiempoPorProblema(String tipoProblema) {

        switch (tipoProblema) {
            case "Problema1":
                return 1;
            case "Problema2":
                return 2;
            default:
                return 0;
        }
    }




    public Tecnico obtenerTecnicoPorId(int id) {
        return tecnicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Técnico no encontrado con ID: " + id));
    }
}