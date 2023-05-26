package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import br.com.uepg.sistemapacientes.services.SituacaoSocioeconomicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchClientAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/situacaosocioeconomica")
public class SituacaoSocioeconomicaController {

    private final SituacaoSocioeconomicaService situacaoSocioeconomicaService;

    @Autowired
    public SituacaoSocioeconomicaController(SituacaoSocioeconomicaService situacaoSocioeconomicaService) {
        this.situacaoSocioeconomicaService = situacaoSocioeconomicaService;
    }


    @GetMapping
    public ResponseEntity<List<SituacaoSocioeconomica>> getSituacaoSocioeconomica() {
        return ResponseEntity.ok(situacaoSocioeconomicaService.getSituacaoSocioeconomicas());
    }
}
