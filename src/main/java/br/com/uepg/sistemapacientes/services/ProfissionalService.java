package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cAlimento;
import br.com.uepg.sistemapacientes.models.cProfissional;
import br.com.uepg.sistemapacientes.repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
