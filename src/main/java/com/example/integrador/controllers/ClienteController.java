package com.example.integrador.controllers;

import com.example.integrador.model.Cliente;
import com.example.integrador.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// En ClienteController
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cliente> altaCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.altaCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> modificarCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente clienteModificado = clienteService.modificarCliente(id, cliente);
        if (clienteModificado != null) {
            return new ResponseEntity<>(clienteModificado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable int id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<Cliente> buscarClientePorCuit(@RequestParam String cuit) {
        try {
            Cliente cliente = clienteService.buscarClientePorCUIT(cuit);
            return ResponseEntity.ok(cliente);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
}}
