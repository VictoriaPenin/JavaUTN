package com.example.integrador.services;

import com.example.integrador.model.Cliente;
import com.example.integrador.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImp implements ClienteService{
    private final ClienteRepository clienteRepository;


    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente altaCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {
        return null;
    }


    @Override
    public Cliente modificarCliente(String id, Cliente cliente){
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if(clienteExistente != null){
            clienteExistente.setRazonSocial(cliente.getRazonSocial());
            clienteExistente.setCuit(cliente.getCuit());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setDomicilio(cliente.getDomicilio());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteRepository.save(clienteExistente);
        }
        return clienteExistente;
    }
}
