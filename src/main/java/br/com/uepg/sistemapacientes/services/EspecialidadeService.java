package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.Especialidade;
import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Especialidade findEspecialidadeByNomeEspecialidade(String nomeEspecialidade) {
        return especialidadeRepository.findEspecialidadeByNomeEspecialidade(nomeEspecialidade);
    }


}
