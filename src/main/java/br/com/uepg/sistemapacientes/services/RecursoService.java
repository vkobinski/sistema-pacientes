package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cRecurso;
import br.com.uepg.sistemapacientes.repositories.RecursoRepository;
import br.com.uepg.sistemapacientes.repositories.TipoRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    @Autowired
    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<cRecurso> getAll() {
        return recursoRepository.findAll();
    }

    public cRecurso getById(Long id) {
        return recursoRepository.findById(id).get();
    }

}
