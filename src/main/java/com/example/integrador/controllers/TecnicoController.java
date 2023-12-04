package com.example.integrador.controllers;

import com.example.integrador.model.Tecnico;
import com.example.integrador.services.TecnicoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTecnicoPorId(@PathVariable String id) {
        try {
            int tecnicoId = Integer.parseInt(id);
            Tecnico tecnico = tecnicoService.obtenerTecnicoPorId(tecnicoId);
            return ResponseEntity.ok(tecnico);
        } catch (NumberFormatException | EntityNotFoundException ex) {
            return ResponseEntity.badRequest().body("ID de técnico no válido");
        }
    }


    @PostMapping("/alta")
    public ResponseEntity<Tecnico> altaTecnico(@RequestBody Tecnico tecnico) {
        Tecnico nuevoTecnico = tecnicoService.altaTecnico(tecnico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTecnico);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Tecnico>> obtenerTecnicosDisponibles(@RequestParam String servicio, @RequestParam String tipoProblema) {
        List<Tecnico> tecnicosDisponibles = tecnicoService.obtenerTecnicosDisponibles(servicio, tipoProblema);
        return ResponseEntity.ok(tecnicosDisponibles);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.badRequest().body("Parámetro incorrecto: " + ex.getName());
    }

}
