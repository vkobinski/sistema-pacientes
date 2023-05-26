package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cFamiliar;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.repositories.FamiliarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FamiliarService {

    private final FamiliarRepository familiarRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public FamiliarService(FamiliarRepository familiarRepository, EnderecoRepository enderecoRepository) {
        this.familiarRepository = familiarRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<cFamiliar> getFamiliares() {
        return familiarRepository.findAll();
    }

    public cFamiliar findFamiliarById(Long id) {
        Optional<cFamiliar> byId = familiarRepository.findById(id);

        return byId.get();
    }

    public cFamiliar criaFamiliar(cFamiliar familiar) {
        return familiarRepository.save(familiar);
    }

}
