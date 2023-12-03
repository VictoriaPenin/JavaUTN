package com.example.integrador.services;

import com.example.integrador.model.Cliente;
import com.example.integrador.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente altaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public Cliente modificarCliente(int id, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + id));

        // Asegúrate de que solo ciertos campos sean modificables según tus reglas de negocio
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setDomicilio(cliente.getDomicilio());

        return clienteRepository.save(clienteExistente);
    }

    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }


    public Cliente buscarClientePorCUIT(String cuit) {
        Optional<Cliente> clienteOptional = clienteRepository.findByCuit(cuit);

        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new EntityNotFoundException("Cliente no encontrado con CUIT: " + cuit);
        }
    }

}
