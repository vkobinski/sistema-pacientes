package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.deserializer.FamiliarWrapper;
import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cFamiliar;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.services.AtendidoService;
import br.com.uepg.sistemapacientes.services.FamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/familiar")
public class FamiliarController {

    private final FamiliarService familiarService;
    private final EnderecoRepository enderecoRepository;
    private final AtendidoService atendidoService;

    @Autowired
    public FamiliarController(FamiliarService familiarService, EnderecoRepository enderecoRepository, AtendidoService atendidoService) {
        this.familiarService = familiarService;
        this.enderecoRepository = enderecoRepository;
        this.atendidoService = atendidoService;
    }

    @PostMapping
    public ResponseEntity<cFamiliar> criaFamiliar(@RequestBody FamiliarWrapper wrapper) {
        cEndereco savedEndereco = enderecoRepository.save(wrapper.endereco);
        wrapper.familiar.setEndereco(savedEndereco);

        cAtendido atendidoById = atendidoService.findAtendidoById(wrapper.atendido);
        wrapper.familiar.setAtendido(atendidoById);

        wrapper.familiar.setAtivo(true);

        cFamiliar familiar = familiarService.criaFamiliar(wrapper.familiar);

        return ResponseEntity.ok(familiar);
    }

    @GetMapping
    public ResponseEntity<List<cFamiliar>> getFamiliares() {
        return ResponseEntity.ok(familiarService.getFamiliares());
    }

    @GetMapping("/{id}")
    public ResponseEntity<cFamiliar> getFamiliarById(@PathVariable Long id) {
        return ResponseEntity.ok(familiarService.findFamiliarById(id));
    }
}
