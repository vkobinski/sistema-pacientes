package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.deserializer.PacienteWrapper;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.services.PacienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController {

    private final PacienteService pacienteService;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public PacienteController(PacienteService pacienteService, EnderecoRepository enderecoRepository) {
        this.pacienteService = pacienteService;
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping
    public ResponseEntity<cPaciente> criaPaciente(@RequestBody PacienteWrapper wrapper) {
        cEndereco savedEndereco = enderecoRepository.save(wrapper.endereco);
        wrapper.paciente.setEndereco(savedEndereco);

        wrapper.paciente.setAtivo(true);

        wrapper.paciente.setData_registro(new Date(System.currentTimeMillis()));
        cPaciente paciente = pacienteService.criaPaciente(wrapper.paciente);

        return ResponseEntity.ok(paciente);
    }

    @GetMapping
    public ResponseEntity<List<cPaciente>> getPacientes() {
        return ResponseEntity.ok(pacienteService.getPacientes());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<cPaciente> getPacienteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(pacienteService.findPacienteById(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<cPaciente> findPacienteByNome(@PathVariable(name = "nome") String nome) {
        Optional<cPaciente> pacienteByNome = pacienteService.findPacienteByNome(nome);
        return pacienteByNome.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = "/cpf/{cpf}")
    public ResponseEntity<cPaciente> findPacienteByCpf(@PathVariable(name = "cpf") String cpf) {
        Optional<cPaciente> pacienteByCpf = pacienteService.findPacienteByCpf(cpf);
        return pacienteByCpf.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<cPaciente> editPaciente(@PathVariable(name = "id") Long id, @RequestBody cPaciente paciente) {
        return ResponseEntity.ok(pacienteService.updatePaciente(id, paciente));
    }

}
