package com.example.integrador.controllers;

import com.example.integrador.model.Cliente;
import com.example.integrador.services.ClienteService;
import com.example.integrador.services.IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesa-de-ayuda")
public class MesaDeAyudaController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private IncidenteService incidenteService;

    @PostMapping("/registrar-incidente")
    public ResponseEntity<String> registrarIncidente(@RequestParam String cuit, @RequestParam String servicio,
                                                     @RequestParam String descripcion, @RequestParam String tipoProblema) {
        Cliente cliente = clienteService.buscarClientePorCUIT(cuit);

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }

        incidenteService.crearIncidente(cliente, servicio, descripcion, tipoProblema);

        return ResponseEntity.ok("Incidente registrado con éxito");
    }
}
