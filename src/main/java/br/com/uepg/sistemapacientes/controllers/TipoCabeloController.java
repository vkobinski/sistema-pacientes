package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import br.com.uepg.sistemapacientes.services.TipoCabeloService;
import br.com.uepg.sistemapacientes.services.TipoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipocabelo")
public class TipoCabeloController {

    private final TipoCabeloService tipoCabeloService;

    @Autowired
    public TipoCabeloController(TipoCabeloService tipoCabeloService) {
        this.tipoCabeloService = tipoCabeloService;
    }

    @GetMapping
    public ResponseEntity<List<TipoCabelo>> getTipoCabelos() {
        return ResponseEntity.ok(tipoCabeloService.getTipoCabelos());
    }

    @PostMapping
    public ResponseEntity<TipoCabelo> criaTipoCabelo(@RequestBody TipoCabelo tipoCabelo) {
        return ResponseEntity.ok(tipoCabeloService.criaTipoCabelo(tipoCabelo));
    }
}
