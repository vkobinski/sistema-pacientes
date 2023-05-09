package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.cVoluntaria;
import br.com.uepg.sistemapacientes.services.VoluntariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voluntaria")
public class VoluntariaController {

    private final VoluntariaService voluntariaService;

    @Autowired
    public VoluntariaController(VoluntariaService voluntariaService) {
        this.voluntariaService = voluntariaService;
    }

    @PostMapping
    public ResponseEntity<cVoluntaria> criaVoluntaria(@RequestBody cVoluntaria voluntaria) {
        return ResponseEntity.ok(voluntariaService.criaVoluntaria(voluntaria));
    }

    @GetMapping
    public ResponseEntity<List<cVoluntaria>> getVoluntarias() {
        return ResponseEntity.ok(voluntariaService.getVoluntarias());
    }
}
