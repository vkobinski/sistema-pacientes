package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.models.cVoluntaria;
import br.com.uepg.sistemapacientes.services.PacienteService;
import br.com.uepg.sistemapacientes.services.VoluntariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<cPaciente> criaPaciente(@RequestBody cPaciente paciente) {
        return ResponseEntity.ok(pacienteService.criaPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<List<cPaciente>> getPacientes() {
        return ResponseEntity.ok(pacienteService.getPacientes());
    }
}
