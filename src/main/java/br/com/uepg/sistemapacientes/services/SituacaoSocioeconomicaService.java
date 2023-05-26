package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import br.com.uepg.sistemapacientes.repositories.SituacaoSocioeconomicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacaoSocioeconomicaService {

    private final SituacaoSocioeconomicaRepository situacaoSocioeconomicaRepository;

    @Autowired
    public SituacaoSocioeconomicaService(SituacaoSocioeconomicaRepository situacaoSocioeconomicaRepository) {
        this.situacaoSocioeconomicaRepository = situacaoSocioeconomicaRepository;
    }


    public List<SituacaoSocioeconomica> getSituacaoSocioeconomicas() {
        return situacaoSocioeconomicaRepository.findAll();
    }

    public SituacaoSocioeconomica getSituacaoSocioeconomicaByNome(String nome) {
        return situacaoSocioeconomicaRepository.findSituacaoSocioeconomicaByNome(nome);
    }
}
