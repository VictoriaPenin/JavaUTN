package com.example.integrador.controllers;

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
