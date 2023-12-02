package com.example.integrador.services;

import com.example.integrador.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listarClientes();

    Cliente altaCliente(Cliente cliente);

    Cliente modificarCliente(Cliente cliente);

    Cliente modificarCliente(int id, Cliente cliente);

    Optional<Cliente> obtenerClientePorCuit(String cuitCliente);
}
