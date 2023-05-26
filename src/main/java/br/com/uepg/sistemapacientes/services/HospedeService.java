package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cHospede;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.repositories.HospedeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HospedeService {

    private final HospedeRepository hospedeRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public HospedeService(HospedeRepository hospedeRepository, EnderecoRepository enderecoRepository) {
        this.hospedeRepository = hospedeRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<cHospede> getHospedes() {
        return hospedeRepository.findAll();
    }

    public cHospede findHospedeById(Long id) {
        Optional<cHospede> byId = hospedeRepository.findById(id);

        return byId.get();
    }

    public cHospede criaHospede(cHospede hospede) {
        return hospedeRepository.save(hospede);
    }

}
