package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.models.cAtendimento;
import br.com.uepg.sistemapacientes.models.cHospede;
import br.com.uepg.sistemapacientes.repositories.AtendimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    @Autowired
    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public List<cAtendimento> getAtendimentos() {
        return atendimentoRepository.findAll();
    }

    public cAtendimento findAtendimentoById(Long id) {
        Optional<cAtendimento> byId = atendimentoRepository.findById(id);

        return byId.get();
    }

    public cAtendimento criaAtendimento(cAtendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

}
