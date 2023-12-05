package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Doacao;
import br.com.uepg.sistemapacientes.services.AtendidoService;
import br.com.uepg.sistemapacientes.services.DoacaoService;
import br.com.uepg.sistemapacientes.services.RecursoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doacao")
public class DoacaoController {

    private final DoacaoService doacaoService;
    private final AtendidoService atendidoService;
    private final RecursoService recursoService;

    public DoacaoController(DoacaoService doacaoService, AtendidoService atendidoService, RecursoService recursoService) {
        this.doacaoService = doacaoService;
        this.atendidoService = atendidoService;
        this.recursoService = recursoService;
    }

    @GetMapping
    public ResponseEntity<List<Doacao>> getDoacoes() {
        return ResponseEntity.ok(doacaoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Doacao> create(@RequestBody DoacaoWrapper doacaoWrapper) {
        System.out.println(doacaoWrapper);
        Doacao doacao = new Doacao();
        doacao.setAtendido(atendidoService.findAtendidoById(doacaoWrapper.atendidoId));
        doacao.setRecurso(recursoService.getById(doacaoWrapper.recursoId));
        doacao.setDataDoacao(new java.sql.Date(Instant.now().toEpochMilli()));
        return ResponseEntity.ok(doacaoService.criaDoacao(doacao));
    }


}