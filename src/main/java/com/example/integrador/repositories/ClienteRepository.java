package com.example.integrador.repositories;

import com.example.integrador.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCuit(String cuitCliente);
}
