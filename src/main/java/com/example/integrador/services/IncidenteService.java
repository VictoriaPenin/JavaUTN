package com.example.integrador.services;

import com.example.integrador.model.Cliente;
import com.example.integrador.model.Incidente;
import com.example.integrador.model.Tecnico;
import com.example.integrador.repositories.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncidenteService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private IncidenteRepository incidenteRepository;

    public void registrarIncidente(String cuitCliente, String servicio, String descripcionProblema, String tipoProblema, boolean esComplejo) {
        // Obtener cliente
        Optional<Cliente> clienteOptional = clienteService.obtenerClientePorCuit(cuitCliente);
        if (!clienteOptional.isPresent()) {
            // Manejar la situación donde no se encuentra el cliente
            // Puedes lanzar una excepción, enviar un mensaje de error, o realizar cualquier otra acción
            return;
        }
        Cliente cliente = clienteOptional.get();


        // Obtener técnicos disponibles para resolver el problema
        List<Tecnico> tecnicosDisponibles = tecnicoService.obtenerTecnicosDisponibles(servicio, tipoProblema);
        if (tecnicosDisponibles.isEmpty()) {
            // Manejar la situación donde no hay técnicos disponibles
            // Puedes lanzar una excepción, enviar un mensaje de error, o realizar cualquier otra acción
            return;
        }

        // Seleccionar un técnico (puedes agregar lógica para elegir al mejor técnico según tus criterios)
        Tecnico tecnicoAsignado = tecnicosDisponibles.get(0);

        // Calcular tiempo estimado de resolución
        int tiempoEstimado = tecnicoService.calcularTiempoEstimado(esComplejo, tipoProblema);

        // Informar al cliente que el incidente ha sido ingresado
        enviarNotificacionCliente(cliente.getEmail(), "Incidente registrado", "Su incidente ha sido ingresado. Tiempo estimado: " + tiempoEstimado + " horas");

        // Crear el incidente
        Incidente incidente = new Incidente();
        incidente.setCliente(cliente);
        incidente.setDescripcionProblema(descripcionProblema);
        incidente.setTipoProblema(tipoProblema);
        incidente.setTecnicoAsignado(tecnicoAsignado);
        incidente.setFechaIngreso(LocalDateTime.now());
        incidente.setEstado("Pendiente"); // Puedes establecer un estado inicial
        incidente.setConsideracionesResolucion(""); // Puedes establecer un valor inicial

        // Guardar el incidente
        incidenteRepository.save(incidente);

        // Notificar al técnico asignado
        enviarNotificacionTecnico(tecnicoAsignado.getEmail(), "Nuevo incidente asignado", "Tienes un nuevo incidente para resolver. Descripción: " + descripcionProblema);
    }

    private void enviarNotificacionCliente(String email, String incidenteRegistrado, String mensaje) {
    }


    private void enviarNotificacionTecnico(String email, String asunto, String mensaje) {
        // Implementar lógica de notificación por correo electrónico o por WhatsApp
    }

    public List<Incidente> obtenerIncidentesAsignados() {
        // Implementa la lógica para obtener los incidentes asignados
        List<Incidente> incidentesAsignados = incidenteRepository.findByEstado("Asignado");
        return incidentesAsignados != null ? incidentesAsignados : new ArrayList<>();
    }

    public Incidente obtenerIncidentePorId(int idIncidente) {
        // Implementa la lógica para obtener un incidente por su ID
        return incidenteRepository.findById(idIncidente).orElse(null);
    }

    public void guardarIncidente(Incidente incidente) {
        // Implementa la lógica para guardar un incidente
        incidenteRepository.save(incidente);
    }
}
