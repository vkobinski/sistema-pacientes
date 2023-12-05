package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cMedicamento;
import br.com.uepg.sistemapacientes.services.MedicamentoService;
import br.com.uepg.sistemapacientes.services.TipoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/medicamento")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;
    private final TipoRecursoService tipoRecursoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService, TipoRecursoService tipoRecursoService) {
        this.medicamentoService = medicamentoService;
        this.tipoRecursoService = tipoRecursoService;
    }

    @GetMapping
    public ResponseEntity<List<cMedicamento>> getMedicamentos() {
        return ResponseEntity.ok(medicamentoService.getMedicamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<cMedicamento> getById(@PathVariable Long id) {
        return ResponseEntity.ok(medicamentoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<cMedicamento> createMedicamento(@RequestBody Map<String, Object> medicamentoCampos) throws ParseException {
        cMedicamento medicamento = new cMedicamento();
        medicamento.setNome((String) medicamentoCampos.get("nome"));
        medicamento.setPreco((Double) medicamentoCampos.get("preco"));
        medicamento.setFarmacia_compra((String) medicamentoCampos.get("farmacia_compra"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse((String) medicamentoCampos.get("data_aquisicao"));

        java.sql.Date data = new java.sql.Date(date.getTime());

        medicamento.setQuantidade((Integer) medicamentoCampos.get("quantidade"));
        medicamento.setData_aquisicao(data);

        TipoRecurso tipoRecurso = tipoRecursoService.getTipoRecursoByTipo((String) medicamentoCampos.get("tipoRecurso"));

        medicamento.setTipoRecurso(tipoRecurso);

        // TODO: Melhorar essa área do código
        //medicamentoService.addQtdInMedicamento(medicamento.getNome(), medicamento.getQuantidade());

        return ResponseEntity.ok(medicamentoService.createMedicamento(medicamento));
    }
}
