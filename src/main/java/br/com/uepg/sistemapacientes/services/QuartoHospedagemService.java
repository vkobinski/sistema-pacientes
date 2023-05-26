package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.repositories.QuartoHospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoHospedagemService {

    private final QuartoHospedagemRepository quartoHospedagemRepository;

    @Autowired
    public QuartoHospedagemService(QuartoHospedagemRepository quartoHospedagemRepository) {
        this.quartoHospedagemRepository = quartoHospedagemRepository;
    }

    public List<QuartoHospedagem> getQuartoHospedagem() {
        return quartoHospedagemRepository.findAll();
    }

    public QuartoHospedagem getQuartoHospedagemByNome(String nome) {
        return quartoHospedagemRepository.getQuartoHospedagemByNome(nome);
    }
}
