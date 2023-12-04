package com.example.integrador.services;

import com.example.integrador.model.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// En OperadorMesaAyudaService

@Service
public class OperadorMesaAyudaService {

    @Autowired
    private IncidenteService incidenteService;


    public void agregarColchonHorasEstimadas(int idIncidente, int horasColchon) {
        Incidente incidente = incidenteService.obtenerIncidentePorId(idIncidente);

        if (incidente != null) {
            int tiempoEstimadoActual = incidente.getTiempoEstimado();
            incidente.setTiempoEstimado(tiempoEstimadoActual + horasColchon);

            incidenteService.guardarIncidente(incidente);
        } else {

            System.out.println("Incidente no encontrado con ID: " + idIncidente);
        }
    }

}

