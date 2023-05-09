package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.cVisita;
import br.com.uepg.sistemapacientes.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/visita")
public class VisitaController {

    private final VisitaService visitaService;

    @Autowired
    public VisitaController(VisitaService visitaService) {
        this.visitaService = visitaService;
    }

    @GetMapping
    public ResponseEntity<List<cVisita>> getVisitas() {
       return ResponseEntity.ok(visitaService.getVisitas());
    }

    @PostMapping
    public ResponseEntity<cVisita> criaVisita(@RequestBody cVisita visita) {
        return ResponseEntity.ok(visitaService.criaVisita(visita));
    }

    @PutMapping
    public ResponseEntity<cVisita> atualizaVisita(@RequestBody Long idVisita, @RequestBody Date date, @RequestBody List<Long> idVoluntarias) {
        return ResponseEntity.ok(visitaService.atualizaVisita(idVisita, date, idVoluntarias));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletaVisita(@RequestBody Long idVisita) {
        return ResponseEntity.ok(visitaService.deletaVisita(idVisita));
    }
}
