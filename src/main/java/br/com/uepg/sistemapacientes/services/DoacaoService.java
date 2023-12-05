package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Doacao;
import br.com.uepg.sistemapacientes.models.cRecurso;
import br.com.uepg.sistemapacientes.repositories.DoacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }


    public List<Doacao> getAll() {
        return doacaoRepository.findAll();
    }

    public Doacao criaDoacao(Doacao doacao) {
        return doacaoRepository.save(doacao);

    }

    public Doacao getById(Long id) {
        return doacaoRepository.findById(id).get();
    }

}
