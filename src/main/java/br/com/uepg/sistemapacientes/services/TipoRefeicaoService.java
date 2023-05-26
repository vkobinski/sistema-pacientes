package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import br.com.uepg.sistemapacientes.repositories.TipoRefeicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoRefeicaoService {

    private final TipoRefeicaoRepository tipoRefeicaoRepository;

    @Autowired
    public TipoRefeicaoService(TipoRefeicaoRepository tipoRefeicaoRepository) {
        this.tipoRefeicaoRepository = tipoRefeicaoRepository;
    }

    public List<TipoRefeicao> getTipoRefeicao() {
        return tipoRefeicaoRepository.findAll();
    }

    public TipoRefeicao getTipoRefeicao(String nome) {
        return tipoRefeicaoRepository.getTipoRefeicaoByNome(nome);
    }
}
