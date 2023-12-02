package com.example.integrador.services;

import com.example.integrador.model.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RRHHService {

    @Autowired
    private IncidenteService incidenteService;

    public List<Incidente> generarReporteDiario() {
        // Obtener incidentes asignados a cada técnico
        return incidenteService.obtenerIncidentesAsignados();
    }
}
