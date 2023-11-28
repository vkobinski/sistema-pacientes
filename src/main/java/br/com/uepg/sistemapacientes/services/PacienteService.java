package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.repositories.PacienteRepository;
import br.com.uepg.sistemapacientes.utils.UpdateUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        paciente.setData_registro(new java.sql.Date(Instant.now().toEpochMilli()));

        return pacienteRepository.save(paciente);
    }

    public Optional<cPaciente> findPacienteByNome(String nome) {

        return pacienteRepository.findByNomeLikeIgnoreCase(nome);
    }

    public Optional<cPaciente> findPacienteByCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    @Transactional
    public cPaciente updatePaciente(Long id, cPaciente paciente) {
        Optional<cPaciente> opPaciente = pacienteRepository.findById(id);

        if(opPaciente.isPresent()) {

            cPaciente existingPaciente = opPaciente.get();

            BeanUtils.copyProperties(paciente, existingPaciente, UpdateUtils.getNullPropertyNames(paciente));

            pacienteRepository.save(existingPaciente);

            return existingPaciente;
        }

        return null;
    }

    public long countPaciente() {
        return pacienteRepository.count();
    }

}
