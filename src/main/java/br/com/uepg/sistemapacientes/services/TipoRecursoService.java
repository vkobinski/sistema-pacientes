package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.repositories.TipoRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoRecursoService {

    private final TipoRecursoRepository tipoRecursoRepository;

    @Autowired
    public TipoRecursoService(TipoRecursoRepository tipoRecursoRepository) {
        this.tipoRecursoRepository = tipoRecursoRepository;
    }

    public List<TipoRecurso> getTipoRecursos() {
        return tipoRecursoRepository.findAll();
    }

    public TipoRecurso getTipoRecursoByTipo(String tipo) {
        return tipoRecursoRepository.getTipoRecursoByTipo(tipo);
    }
}
