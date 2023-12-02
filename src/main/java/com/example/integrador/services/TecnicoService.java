package com.example.integrador.services;

import com.example.integrador.model.Incidente;
import com.example.integrador.model.Tecnico;
import com.example.integrador.repositories.IncidenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public abstract class TecnicoService {

    @Autowired
    private IncidenteRepository incidenteRepository;

    public void resolverIncidente(int idIncidente, String consideraciones) {
        // Obtener el incidente por su ID
        Incidente incidente = incidenteRepository.findById(idIncidente).orElseThrow(() -> new EntityNotFoundException("Incidente no encontrado con ID: " + idIncidente));

        // Marcar el incidente como "resuelto" y registrar las consideraciones
        incidente.setEstado("Resuelto");
        incidente.setConsideracionesResolucion(consideraciones);
        incidente.setFechaResolucion(LocalDateTime.now());

        // Guardar el incidente actualizado
        incidenteRepository.save(incidente);

        // Enviar notificación al cliente
        enviarNotificacionCliente(incidente.getCliente().getEmail(), "Incidente Resuelto", "Su incidente ha sido resuelto. Consideraciones: " + consideraciones);
    }

    private void enviarNotificacionCliente(String email, String asunto, String mensaje) {
        // Implementar lógica de notificación por correo electrónico o por WhatsApp
    }

    public abstract Tecnico altaTecnico(Tecnico tecnico);

    public abstract int calcularTiempoEstimado(boolean esComplejo, String tipoProblema);

    public abstract List<Tecnico> obtenerTecnicosDisponibles(String servicio, String tipoProblema);

    public Tecnico obtenerTecnicoConMasIncidentesResueltosUltimosNDias(int nDias) {
        return null;
    }

    public Tecnico obtenerTecnicoConMasIncidentesResueltosEspecialidadUltimosNDias(String especialidad, int nDias) {
        return null;
    }

    public Tecnico obtenerTecnicoMasRapidoResolviendo() {
        return null;
    }
}
