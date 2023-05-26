package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.Especialidade;
import br.com.uepg.sistemapacientes.models.cProfissional;
import br.com.uepg.sistemapacientes.repositories.TipoRecursoRepository;
import br.com.uepg.sistemapacientes.services.EspecialidadeService;
import br.com.uepg.sistemapacientes.services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/profissional")
public class ProfissionalController {

    private final ProfissionalService profissionalService;
    private final EspecialidadeService especialidadeService;
    private final TipoRecursoRepository tipoRecursoRepository;

    @Autowired
    public ProfissionalController(ProfissionalService profissionalService, EspecialidadeService especialidadeService,
                                  TipoRecursoRepository tipoRecursoRepository) {
        this.profissionalService = profissionalService;
        this.especialidadeService = especialidadeService;
        this.tipoRecursoRepository = tipoRecursoRepository;
    }

    @GetMapping
    public ResponseEntity<List<cProfissional>> getProfissionais() {
        return ResponseEntity.ok(profissionalService.getProfissionais());
    }

    @PostMapping
    public ResponseEntity<cProfissional> createProfissional(@RequestBody Map<String, Object> profissionalCampos) throws ParseException {
        cProfissional profissional = new cProfissional();

        profissional.setAtivo(true);
        profissional.setDataCadastro(Timestamp.from(Instant.now()));

        profissional.setNome((String) profissionalCampos.get("nome"));

        Especialidade especialidade = especialidadeService.findEspecialidadeByNomeEspecialidade((String) profissionalCampos.get("especialidade"));
        profissional.setEspecialidade(especialidade);

        return ResponseEntity.ok(profissionalService.createProfissional(profissional));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<cProfissional> getProfissionalByNome(@PathVariable(name = "nome") String nome) {
        return ResponseEntity.ok(profissionalService.findProfissionalByNome(nome));
    }

    @PutMapping("/ativo/{id}")
    public ResponseEntity<cProfissional> alternaAtivoProfissional(@PathVariable (name = "id") Long id)  {
        return ResponseEntity.ok(profissionalService.alternaAtivoProfissionalById(id));
    }

    @GetMapping("/especialidade/{especialidade}")
    public ResponseEntity<List<cProfissional>> getAllProfissionaisByEspecialidade(@PathVariable(name = "especialidade") Long especialidade) {
        Especialidade especialidadeById = especialidadeService.findEspecialidadeById(especialidade);
        return ResponseEntity.ok(profissionalService.findProfissionalByEspecialidade(especialidadeById));
    }
}
