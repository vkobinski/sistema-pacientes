package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.services.EstagioDoencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estagiodoenca")
public class EstagioDoencaController {

    private final EstagioDoencaService estagioDoencaService;

    @Autowired
    public EstagioDoencaController(EstagioDoencaService estagioDoencaService) {
        this.estagioDoencaService = estagioDoencaService;
    }

    @GetMapping
    public ResponseEntity<List<EstagioDoenca>> getEstagioDoencas() {
        return ResponseEntity.ok(estagioDoencaService.getEstagioDoencas());
    }
}
