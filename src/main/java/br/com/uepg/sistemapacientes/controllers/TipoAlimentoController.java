package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoAlimento;
import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.services.TipoAlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipoalimento")
public class TipoAlimentoController {

    private final TipoAlimentoService tipoAlimentoService;

    @Autowired
    public TipoAlimentoController(TipoAlimentoService tipoAlimentoService) {
        this.tipoAlimentoService = tipoAlimentoService;
    }


    @GetMapping
    public ResponseEntity<List<TipoAlimento>> getTipoAlimentos() {
        return ResponseEntity.ok(tipoAlimentoService.getTipoAlimentos());
    }
}
