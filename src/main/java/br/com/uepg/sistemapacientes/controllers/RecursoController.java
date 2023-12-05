package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cRecurso;
import br.com.uepg.sistemapacientes.services.RecursoService;
import br.com.uepg.sistemapacientes.services.TipoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/recurso")
public class RecursoController {

    private final RecursoService recursoService;

    @Autowired
    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRecursoById(@PathVariable Long id) {

        return ResponseEntity.ok(recursoService.getById(id));

    }

    @GetMapping
    public ResponseEntity<List<cRecurso>> getTipoRecursos() {
        return ResponseEntity.ok(recursoService.getAll());
    }
}
