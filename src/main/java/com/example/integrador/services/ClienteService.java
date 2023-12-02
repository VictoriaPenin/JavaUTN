package com.example.integrador.services;

import com.example.integrador.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> listarClientes();

    Cliente altaCliente(Cliente cliente);

    Cliente modificarCliente(Cliente cliente);



    Cliente modificarCliente(int id, Cliente cliente);
}
