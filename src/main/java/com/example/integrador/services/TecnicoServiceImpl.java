package com.example.integrador.services;

import com.example.integrador.model.Tecnico;
import com.example.integrador.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TecnicoServiceImpl implements TecnicoService {


            @Autowired
            private TecnicoRepository tecnicoRepository;

    @Override
    public Tecnico altaTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }
}
