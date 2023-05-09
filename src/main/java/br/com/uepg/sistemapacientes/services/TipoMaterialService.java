package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.TipoMaterial;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.repositories.TipoMaterialRepository;
import br.com.uepg.sistemapacientes.repositories.TipoRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMaterialService {

    private final TipoMaterialRepository tipoMaterialRepository;

    @Autowired
    public TipoMaterialService(TipoMaterialRepository tipoMaterialRepository) {
        this.tipoMaterialRepository = tipoMaterialRepository;
    }

    public List<TipoMaterial> getTipoMaterial() {
        return tipoMaterialRepository.findAll();
    }

    public TipoMaterial getTipoMaterialByNome(String nome) {
        return  tipoMaterialRepository.getTipoMaterialByNome(nome);
    }
}
