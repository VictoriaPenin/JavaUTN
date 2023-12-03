package com.example.integrador.controllers;

import com.example.integrador.model.IncidenteFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IncidenteController {

    @GetMapping("/")
    public String mostrarFormulario() {
        return "incidente-form";
    }

    @PostMapping("/registrar-incidente")
    public String registrarIncidente(@ModelAttribute("incidenteFormulario") IncidenteFormulario incidenteFormulario) {
        // Lógica de procesamiento y almacenamiento en la base de datos
        return "redirect:/incidente-form";
    }

}
