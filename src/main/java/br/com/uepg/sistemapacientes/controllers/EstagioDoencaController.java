package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.services.EstagioDoencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/estagiodoenca")
public class EstagioDoencaController {

    private final EstagioDoencaService estagioDoencaService;

    @Autowired
    public EstagioDoencaController(EstagioDoencaService estagioDoencaService) {
        this.estagioDoencaService = estagioDoencaService;
    }

    @PostMapping
    public ResponseEntity<EstagioDoenca> criaEstagioDoenca(@RequestBody HashMap<String, Object> dados) {

        String nomeEstagio = (String) dados.get("nome");
        EstagioDoenca estagioDoenca = new EstagioDoenca();
        estagioDoenca.setNome(nomeEstagio);

        return ResponseEntity.ok(estagioDoencaService.criaEstagioDoenca(estagioDoenca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaEstagioDoenca(@PathVariable Long id) {
        if(estagioDoencaService.deletaEstagioDoenca(id)) {
            return ResponseEntity.ok("Estágio excluído com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível excluir Estágio");
        }
    }

    @GetMapping
    public ResponseEntity<List<EstagioDoenca>> getEstagioDoencas() {
        return ResponseEntity.ok(estagioDoencaService.getEstagioDoencas());
    }
}
