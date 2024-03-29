package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.services.QuartoHospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quartohospedagem")
public class QuartoHospedagemController {

    private final QuartoHospedagemService quartoHospedagemService;

    @Autowired
    public QuartoHospedagemController(QuartoHospedagemService quartoHospedagemService) {
        this.quartoHospedagemService = quartoHospedagemService;
    }

    @GetMapping
    public ResponseEntity<List<QuartoHospedagem>> getQuartosHospedagem() {
        return ResponseEntity.ok(quartoHospedagemService.getQuartoHospedagem());
    }

    @PostMapping
    public ResponseEntity<QuartoHospedagem> criaQuartoHospedagem(@RequestBody HashMap<String, Object> dados) {

        String nomeQuarto = (String) dados.get("nome");
        QuartoHospedagem quartoHospedagem = new QuartoHospedagem();
        quartoHospedagem.setNome(nomeQuarto);

        return ResponseEntity.ok(quartoHospedagemService.cria(quartoHospedagem));
    }
}
