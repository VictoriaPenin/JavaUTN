package com.example.integrador.services;

import com.example.integrador.model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformesService {

    @Autowired
    private TecnicoService tecnicoService;

    public Tecnico obtenerTecnicoMasIncidentesResueltosUltimosNDias(int nDias) {
        // Implementar lógica para obtener el técnico con más incidentes resueltos en los últimos N días
        return tecnicoService.obtenerTecnicoConMasIncidentesResueltosUltimosNDias(nDias);
    }

    public Tecnico obtenerTecnicoMasIncidentesResueltosEspecialidadUltimosNDias(String especialidad, int nDias) {
        // Implementar lógica para obtener el técnico con más incidentes resueltos en una determinada especialidad en los últimos N días
        return tecnicoService.obtenerTecnicoConMasIncidentesResueltosEspecialidadUltimosNDias(especialidad, nDias);
    }

    public Tecnico obtenerTecnicoMasRapidoResolviendo() {
        // Implementar lógica para obtener el técnico que más rápido resolvió los incidentes
        return tecnicoService.obtenerTecnicoMasRapidoResolviendo();
    }
}
