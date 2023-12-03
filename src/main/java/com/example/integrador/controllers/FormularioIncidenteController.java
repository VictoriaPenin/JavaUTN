package com.example.integrador.controllers;

import org.springframework.ui.Model;
import com.example.integrador.model.IncidenteFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioIncidenteController {


    @GetMapping("/formularioIncidente")
    public String mostrarFormularioIncidente(Model model) {
        model.addAttribute("incidenteFormulario", new IncidenteFormulario());
        return "formularioIncidente";
    }



    @PostMapping("/formularioIncidente.html")
    public String procesarFormularioIncidente(@ModelAttribute IncidenteFormulario incidenteFormulario, Model model) {
        // Aquí puedes procesar el formulario, por ejemplo, guardar los datos en la base de datos
        // y luego redirigir a una página de éxito o volver a mostrar el formulario con mensajes de éxito

        // Por ahora, solo redirigir a la misma página (puedes cambiar esto según tus necesidades)
        return "formularioIncidente";
    }
}
