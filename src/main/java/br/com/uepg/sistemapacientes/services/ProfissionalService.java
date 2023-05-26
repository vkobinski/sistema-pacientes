package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.Especialidade;
import br.com.uepg.sistemapacientes.models.cAlimento;
import br.com.uepg.sistemapacientes.models.cProfissional;
import br.com.uepg.sistemapacientes.repositories.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    @Autowired
    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }


    public List<cProfissional> getProfissionais() {
        return profissionalRepository.findAll();
    }

    public cProfissional createProfissional(cProfissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @Transactional
    public cProfissional alternaAtivoProfissionalById(Long id) {
        Optional<cProfissional> profissionalOp = profissionalRepository.findById(id);

        if(profissionalOp.isPresent()){
            boolean status = profissionalOp.get().isAtivo();
            profissionalOp.get().setAtivo(!status);
            return profissionalOp.get();
        }

        throw new EntityNotFoundException("Não existe profissional com ID: " + id);
    }

    public cProfissional findProfissionalById(Long id) {
        Optional<cProfissional> byId = profissionalRepository.findById(id);

        if(byId.isPresent()) return byId.get();

        throw new EntityNotFoundException("Não foi possível encontrar profissional com ID: " + id);
    }

    public cProfissional findProfissionalByNome(String nome) {
        Optional<cProfissional> byId = profissionalRepository.findByNomeLikeIgnoreCase(nome);

        if(byId.isPresent()) return byId.get();

        throw new EntityNotFoundException("Não foi possível encontrar profissional com Nome: " + nome);
    }

    public List<cProfissional> findProfissionalByEspecialidade(Especialidade especialidade) {
        List<cProfissional> byId = profissionalRepository.findAllByEspecialidade(especialidade);

        if(byId.isEmpty()) {
            throw new EntityNotFoundException("Não foi possível encontrar algum profissional com especialidade: " + especialidade.getNomeEspecialidade());
        }

        return byId;
    }


}
