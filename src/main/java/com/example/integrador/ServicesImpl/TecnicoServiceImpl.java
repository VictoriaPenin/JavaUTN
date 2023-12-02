package com.example.integrador.ServicesImpl;

import com.example.integrador.model.Tecnico;
import com.example.integrador.repositories.TecnicoRepository;
import com.example.integrador.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImpl extends TecnicoService {


            @Autowired
            private TecnicoRepository tecnicoRepository;

    @Override
    public Tecnico altaTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @Override
    public int calcularTiempoEstimado(boolean esComplejo, String tipoProblema) {
        return 0;
    }

    @Override
    public List<Tecnico> obtenerTecnicosDisponibles(String servicio, String tipoProblema) {
        return null;
    }
}
