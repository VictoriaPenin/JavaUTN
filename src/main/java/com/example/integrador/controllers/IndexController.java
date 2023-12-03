package com.example.integrador.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String mostrarIndex() {
        return "index";
    }

    @GetMapping("/cliente")
    public String mostrarVistaCliente(Model model) {
        // Lógica para cargar datos si es necesario
        return "cliente/index";
    }

}