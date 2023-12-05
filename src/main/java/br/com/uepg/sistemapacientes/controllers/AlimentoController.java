package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoAlimento;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cAlimento;
import br.com.uepg.sistemapacientes.models.cMedicamento;
import br.com.uepg.sistemapacientes.repositories.TipoRecursoRepository;
import br.com.uepg.sistemapacientes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/alimento")
public class AlimentoController {

    private final AlimentoService alimentoService;
    private final TipoAlimentoService tipoAlimentoService;
    private final TipoRecursoRepository tipoRecursoService;

    @Autowired
    public AlimentoController(AlimentoService alimentoService, TipoAlimentoService tipoAlimentoService, TipoRecursoRepository tipoRecursoService) {
        this.alimentoService = alimentoService;
        this.tipoAlimentoService = tipoAlimentoService;
        this.tipoRecursoService = tipoRecursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<cAlimento> getById(@PathVariable Long id) {
        return ResponseEntity.ok(alimentoService.getById(id));
    }


    @GetMapping
    public ResponseEntity<List<cAlimento>> getAlimentos() {
        return ResponseEntity.ok(alimentoService.getAlimentos());
    }

    @PostMapping
    public ResponseEntity<cAlimento> createAlimento(@RequestBody Map<String, Object> alimentoCampos) throws ParseException {
        cAlimento alimento = new cAlimento();

        TipoAlimento tipoAlimento = tipoAlimentoService.getTipoAlimentoByTipo((String) alimentoCampos.get("tipoAlimento"));
        alimento.setTipoAlimento(tipoAlimento);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse((String) alimentoCampos.get("data_aquisicao"));

        Date data = new Date(date.getTime());

        alimento.setQuantidade((Integer) alimentoCampos.get("quantidade"));
        alimento.setData_aquisicao(data);

        TipoRecurso tipoRecurso = tipoRecursoService.getTipoRecursoByTipo((String) alimentoCampos.get("tipoRecurso"));
        alimento.setTipoRecurso(tipoRecurso);

        return ResponseEntity.ok(alimentoService.createAlimento(alimento));
    }
}
