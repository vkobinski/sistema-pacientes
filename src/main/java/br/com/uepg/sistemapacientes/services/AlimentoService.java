package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cAlimento;
import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.repositories.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;

    @Autowired
    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }

    public List<cAlimento> getAlimentos() {
        return alimentoRepository.findAll();
    }

    public cAlimento createAlimento(cAlimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public cAlimento getById(Long id) {
        return  alimentoRepository.findById(id).get();
    }


}
