package com.example.integrador.services;

import com.example.integrador.model.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// En OperadorMesaAyudaService

@Service
public class OperadorMesaAyudaService {

    @Autowired
    private IncidenteService incidenteService;

    // ... (otros métodos anteriores)

    public void agregarColchonHorasEstimadas(int idIncidente, int horasColchon) {
        // Obtener el incidente por su ID
        Incidente incidente = incidenteService.obtenerIncidentePorId(idIncidente);

        if (incidente != null) {
            // Actualizar el tiempo estimado con el colchón de horas
            int tiempoEstimadoActual = incidente.getTiempoEstimado();
            incidente.setTiempoEstimado(tiempoEstimadoActual + horasColchon);

            // Guardar el incidente actualizado
            incidenteService.guardarIncidente(incidente);
        } else {
            // Manejar el caso en que el incidente no se encuentre
            // Puedes lanzar una excepción, loggear un mensaje, etc.
            System.out.println("Incidente no encontrado con ID: " + idIncidente);
        }
    }

    // ... (otros métodos anteriores)
}

