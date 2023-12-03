package com.example.integrador.controllers;

import ch.qos.logback.core.model.Model;
import com.example.integrador.model.Incidente;
import com.example.integrador.model.IncidenteFormulario;
import com.example.integrador.services.IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// En IncidenteController
@RestController
@RequestMapping("/incidentes")
public class IncidenteController {

    @Autowired
    private IncidenteService incidenteService;

    @GetMapping("/index")
    public String mostrarFormularioIncidente(Model model) {
        // Puedes inicializar el objeto incidenteFormulario aquí si es necesario
        model.addText("incidenteFormulario");
        return "index";
    }

    @GetMapping("/asignados")
    public List<Incidente> obtenerIncidentesAsignados() {
        return incidenteService.obtenerIncidentesAsignados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidente> obtenerIncidentePorId(@PathVariable int id) {
        return ResponseEntity.ok(incidenteService.obtenerIncidentePorId(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<Incidente> guardarIncidente(@RequestBody Incidente incidente) {
        incidenteService.guardarIncidente(incidente);
        return ResponseEntity.ok(incidente);
    }
}
