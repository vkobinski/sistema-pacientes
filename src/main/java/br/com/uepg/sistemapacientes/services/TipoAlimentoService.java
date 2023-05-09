package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.TipoAlimento;
import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.repositories.TipoAlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAlimentoService {

    private final TipoAlimentoRepository tipoAlimentoRepository;

    @Autowired
    public TipoAlimentoService(TipoAlimentoRepository tipoAlimentoRepository) {
        this.tipoAlimentoRepository = tipoAlimentoRepository;
    }

    public List<TipoAlimento> getTipoAlimentos() {
        return tipoAlimentoRepository.findAll();
    }

    public TipoAlimento getTipoAlimentoByTipo(String tipo) {
        return tipoAlimentoRepository.getTipoAlimentoByNome(tipo);
    }
}
