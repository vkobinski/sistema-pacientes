package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.services.TipoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiporecurso")
public class TipoRecursoController {

    private final TipoRecursoService tipoRecursoService;

    @Autowired
    public TipoRecursoController(TipoRecursoService tipoRecursoService) {
        this.tipoRecursoService = tipoRecursoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoRecurso>> getTipoRecursos() {
        return ResponseEntity.ok(tipoRecursoService.getTipoRecursos());
    }
}
