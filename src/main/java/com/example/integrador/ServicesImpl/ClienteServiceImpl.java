package com.example.integrador.ServicesImpl;

import com.example.integrador.model.Cliente;
import com.example.integrador.repositories.ClienteRepository;
import com.example.integrador.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        // Implementa la lógica para listar clientes
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes != null ? clientes : new ArrayList<>();
    }

    @Override
    public Cliente altaCliente(Cliente cliente) {
        // Implementa la lógica para dar de alta un cliente
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {
        // Implementa la lógica para modificar un cliente
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modificarCliente(int id, Cliente cliente) {
        // Implementa la lógica para modificar un cliente por su ID
        cliente.setId(id);  // Asegúrate de que el cliente tenga el ID correcto
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> obtenerClientePorCuit(String cuitCliente) {
        // Implementa la lógica para obtener un cliente por su CUIT
        return clienteRepository.findByCuit(cuitCliente);
    }
}
