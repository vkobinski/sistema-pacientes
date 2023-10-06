package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, EnderecoRepository enderecoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<cPaciente> getPacientes() {
        return pacienteRepository.findAll();
    }

    public cPaciente findPacienteById(Long id) {
        Optional<cPaciente> byId = pacienteRepository.findById(id);

        return byId.get();
    }

    public cPaciente criaPaciente(cPaciente paciente) {

        return pacienteRepository.save(paciente);
    }

}
