package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.Especialidade;
import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/especialidade")
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @Autowired
    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Especialidade>> getEspecialidade() {
        return ResponseEntity.ok(especialidadeService.getEspecialidades());
    }

    @PostMapping
    public ResponseEntity<Especialidade> createEspecialidade(@RequestBody Especialidade especialidade) {
        return ResponseEntity.ok(especialidadeService.createEspecialidade(especialidade));
    }
}
