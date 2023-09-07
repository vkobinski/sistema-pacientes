package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.repositories.EstagioDoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstagioDoencaService {

    private final EstagioDoencaRepository estagioDoencaRepository;

    @Autowired
    public EstagioDoencaService(EstagioDoencaRepository estagioDoencaRepository) {
        this.estagioDoencaRepository = estagioDoencaRepository;
    }


    public List<EstagioDoenca> getEstagioDoencas() {
        return estagioDoencaRepository.findAll();
    }

    public EstagioDoenca getEstagioDoencaByNome(String nome) {
        return estagioDoencaRepository.findEstagioDoencaByNome(nome);
    }

    public boolean deletaEstagioDoenca(Long id) {
        Optional<EstagioDoenca> estagio = estagioDoencaRepository.findById(id);

        if(estagio.isPresent()) {
            estagio.get().setAtivo(false);
            estagioDoencaRepository.save(estagio.get());
            return true;
        }
        return false;
    }

    public EstagioDoenca criaEstagioDoenca(EstagioDoenca estagioDoenca) {
        return estagioDoencaRepository.save(estagioDoenca);
    }
}
