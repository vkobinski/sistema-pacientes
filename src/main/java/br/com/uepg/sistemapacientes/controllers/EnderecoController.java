package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoAlimento;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cAlimento;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cFamiliar;
import br.com.uepg.sistemapacientes.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<cEndereco>> getEnderecos() {
        return ResponseEntity.ok(enderecoService.getEnderecos());
    }

    @PostMapping
    public ResponseEntity<cEndereco> createEndereco(@RequestBody cEndereco endereco) {
        return ResponseEntity.ok(enderecoService.createEndereco(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<cEndereco> getEnderecoById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(enderecoService.getEnderecoById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<cEndereco> updateEndereco(@PathVariable(name = "id")Long id, @RequestBody cEndereco endereco) {
        return ResponseEntity.ok(enderecoService.updateEndreco(id, endereco));
    }
}
