package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.repositories.TipoCabeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCabeloService {

    private final TipoCabeloRepository tipoCabeloRepository;

    @Autowired
    public TipoCabeloService(TipoCabeloRepository tipoCabeloRepository, TipoCabeloRepository tipoCabeloRepository1) {
        this.tipoCabeloRepository = tipoCabeloRepository1;
    }

    public List<TipoCabelo> getTipoCabelos() {
        return tipoCabeloRepository.findAll();
    }

    public TipoCabelo getTipoCabeloByTipo(String tipo) {
        return tipoCabeloRepository.getTipoCabeloByTipo(tipo);
    }

    public TipoCabelo criaTipoCabelo(TipoCabelo tipoCabelo) {
        return tipoCabeloRepository.save(tipoCabelo);
    }
}
