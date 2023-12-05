package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.models.cRoupa;
import br.com.uepg.sistemapacientes.repositories.CabeloRepository;
import br.com.uepg.sistemapacientes.repositories.RoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoupaService {

    private final RoupaRepository roupaRepository;

    @Autowired
    public RoupaService(RoupaRepository roupaRepository) {
        this.roupaRepository = roupaRepository;
    }

    public List<cRoupa> getRoupas() {
        return roupaRepository.findAll();
    }

    public cRoupa createRoupa(cRoupa cRoupa) {
        return roupaRepository.save(cRoupa);
    }

    public cRoupa getById(Long id) {
        return roupaRepository.findById(id).get();
    }


}
