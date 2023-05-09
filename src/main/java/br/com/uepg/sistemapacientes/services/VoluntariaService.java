package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cVoluntaria;
import br.com.uepg.sistemapacientes.repositories.VoluntariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntariaService {

    private final VoluntariaRepository voluntariaRepository;

    @Autowired
    public VoluntariaService(VoluntariaRepository voluntariaRepository) {
        this.voluntariaRepository = voluntariaRepository;
    }

    public cVoluntaria criaVoluntaria(cVoluntaria voluntaria) {
        return voluntariaRepository.save(voluntaria);
    }

    public List<cVoluntaria> getVoluntarias() {
        return voluntariaRepository.findAll();
    }
}

