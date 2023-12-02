package com.example.integrador.services;

import com.example.integrador.model.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadorMesaAyudaService {

    @Autowired
    private IncidenteService incidenteService;

    public void agregarColchonHorasEstimadas(int idIncidente, int horasColchon) {
        // Obtener el incidente por su ID
        Incidente incidente = incidenteService.obtenerIncidentePorId(idIncidente);

        // Actualizar el tiempo estimado con el colchón de horas
        incidente.setTiempoEstimado(incidente.getTiempoEstimado() + horasColchon);

        // Guardar el incidente actualizado
        incidenteService.guardarIncidente(incidente);
    }
}
