package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import br.com.uepg.sistemapacientes.services.TipoRefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiporefeicao")
public class TipoRefeicaoController {

    private final TipoRefeicaoService tipoRefeicaoService;

    @Autowired
    public TipoRefeicaoController(TipoRefeicaoService tipoRefeicaoService) {
        this.tipoRefeicaoService = tipoRefeicaoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoRefeicao>> getTipoRefeicoes() {
        return ResponseEntity.ok(tipoRefeicaoService.getTipoRefeicao());
    }
}
