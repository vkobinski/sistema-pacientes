package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.cVisita;
import br.com.uepg.sistemapacientes.models.cVoluntaria;
import br.com.uepg.sistemapacientes.services.PacienteService;
import br.com.uepg.sistemapacientes.services.VisitaService;
import br.com.uepg.sistemapacientes.services.VoluntariaService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/v1/visita")
public class VisitaController {

    private final VisitaService visitaService;
    private final PacienteService pacienteService;
    private final VoluntariaService voluntariaService;

    @Autowired
    public VisitaController(VisitaService visitaService, PacienteService pacienteService, VoluntariaService voluntariaService) {
        this.visitaService = visitaService;
        this.pacienteService = pacienteService;
        this.voluntariaService = voluntariaService;
    }

    @GetMapping
    public ResponseEntity<List<cVisita>> getVisitas() {
       return ResponseEntity.ok(visitaService.getVisitas());
    }

    @PostMapping
    public ResponseEntity<cVisita> criaVisita(@RequestBody Map<String, Object> visitaParams) throws ParseException {

        cVisita visita = new cVisita();

        visita.setPaciente(pacienteService.findPacienteById(Long.valueOf((Integer) visitaParams.get("paciente"))));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse((String) visitaParams.get("data_visita"));

        Date data = new Date(date.getTime());

        visita.setData_visita(data);
        Set<cVoluntaria> voluntarias = new HashSet<>();

        ArrayList<Integer> voluntariaList = (ArrayList<Integer>) visitaParams.get("voluntarias");

        for (Integer s : voluntariaList) {
            Long idVol = Long.valueOf(s);
            cVoluntaria voluntariaById = voluntariaService.findVoluntariaById(idVol);
            voluntarias.add(voluntariaById);
        }

        visita.setVoluntarias(voluntarias);

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

    @PutMapping("/ocorreu")
    public ResponseEntity<cVisita> setVisitaOcorrida(@RequestParam Long idVisita, @RequestParam String descricaoVisita) {
        cVisita visita = visitaService.setVisitaOcorrida(idVisita, descricaoVisita);
        return ResponseEntity.ok(visita);
    }

    @Getter
    @Setter
    public class CreateVisitaRequest {
       private Long pacienteId;
    }
}
