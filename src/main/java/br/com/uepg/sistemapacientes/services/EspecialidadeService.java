package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.Especialidade;
import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.repositories.EspecialidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    @Autowired
    public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }


    public List<Especialidade> getEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Especialidade createEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public Especialidade findEspecialidadeById(Long id) {
        Optional<Especialidade> byId = especialidadeRepository.findById(id);
        if(byId.isPresent()) return byId.get();

        throw new EntityNotFoundException("Especialidade com ID " + id + " não encontrada");
    }

    public Especialidade findEspecialidadeByNomeEspecialidade(String nomeEspecialidade) {
        return especialidadeRepository.findEspecialidadeByNomeEspecialidade(nomeEspecialidade);
    }


}
