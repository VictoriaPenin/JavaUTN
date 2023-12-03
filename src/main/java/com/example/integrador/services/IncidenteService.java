package com.example.integrador.services;

import com.example.integrador.model.Cliente;
import com.example.integrador.model.Incidente;
import com.example.integrador.model.Tecnico;
import com.example.integrador.repositories.IncidenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// En IncidenteService

@Service
public class IncidenteService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private IncidenteRepository incidenteRepository;

    // ... (métodos anteriores)


    public void crearIncidente(Cliente cliente, String servicio, String descripcion, String tipoProblema) {
        Incidente incidente = new Incidente();
        incidente.setCliente(cliente);
        incidente.setServicio(servicio);
        incidente.setDescripcionProblema(descripcion);
        incidente.setTipoProblema(tipoProblema);

        // Lógica para obtener técnicos disponibles
        List<Tecnico> tecnicosDisponibles = tecnicoService.obtenerTecnicosDisponibles(servicio, tipoProblema);

        // Asignar técnico (puedes implementar tu lógica de asignación)
        Tecnico tecnicoAsignado = tecnicosDisponibles.get(0); // Aquí necesitarás tu lógica

        incidente.setTecnicoAsignado(tecnicoAsignado);

        // Lógica para estimar tiempo de resolución
        int tiempoEstimado = tecnicoService.estimarTiempoResolucion(tecnicoAsignado, tipoProblema);
        incidente.setTiempoEstimado(tiempoEstimado);

        incidenteRepository.save(incidente);

        // Lógica para enviar notificación al técnico
        tecnicoService.enviarNotificacionNuevoIncidente(tecnicoAsignado, incidente);
    }


    private void enviarNotificacionCliente(String email, String incidenteRegistrado, String s) {
        
    }



    public void resolverIncidente(int idIncidente, String consideraciones) {
        // Obtener el incidente por su ID
        Incidente incidente = incidenteRepository.findById(idIncidente)
                .orElseThrow(() -> new EntityNotFoundException("Incidente no encontrado con ID: " + idIncidente));

        // Marcar el incidente como "resuelto" y registrar las consideraciones
        incidente.setEstado("Resuelto");
        incidente.setConsideracionesResolucion(consideraciones);
        incidente.setFechaResolucion(LocalDateTime.now());

        // Guardar el incidente actualizado
        incidenteRepository.save(incidente);

        // Enviar notificación al cliente
        enviarNotificacionCliente(incidente.getCliente().getEmail(), "Incidente Resuelto", "Su incidente ha sido resuelto. Consideraciones: " + consideraciones);
    }

    public Incidente obtenerIncidentePorId(int idIncidente) {
        return incidenteRepository.findById(idIncidente)
                .orElseThrow(() -> new EntityNotFoundException("Incidente no encontrado con ID: " + idIncidente));
    }

    public void guardarIncidente(Incidente incidente) {
        incidenteRepository.save(incidente);
    }

    public List<Incidente> obtenerIncidentesAsignados() {
        // Implementa la lógica para obtener los incidentes asignados
        List<Incidente> incidentesAsignados = incidenteRepository.findByEstado("Asignado");
        return incidentesAsignados != null ? incidentesAsignados : new ArrayList<>();
    }
    // ... (otros métodos anteriores)
}
