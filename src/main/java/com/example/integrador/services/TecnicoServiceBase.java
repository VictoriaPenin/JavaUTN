package com.example.integrador.services;

import com.example.integrador.model.Tecnico;

public interface TecnicoServiceBase {
    Tecnico obtenerTecnicoConMasIncidentesResueltosEspecialidadUltimosNDias(String especialidad, int nDias);
    Tecnico obtenerTecnicoConMasIncidentesResueltosUltimosNDias(int nDias);
    Tecnico obtenerTecnicoMasRapidoResolviendo();
}

