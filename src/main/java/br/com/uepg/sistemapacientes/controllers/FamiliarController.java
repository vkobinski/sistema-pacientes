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

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

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

        wrapper.familiar.setData_registro(new Date(System.currentTimeMillis()));

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

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<cFamiliar> findFamiliarByNome(@PathVariable(name = "nome") String nome) {
        Optional<cFamiliar> familiarByNome = familiarService.findFamiliarByNome(nome);
        return familiarByNome.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = "/cpf/{cpf}")
    public ResponseEntity<cFamiliar> findPacienteByCpf(@PathVariable(name = "cpf") String cpf) {
        Optional<cFamiliar> familiarByCpf = familiarService.findFamiliarByCpf(cpf);
        return familiarByCpf.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<cFamiliar> updateFamiliar(@PathVariable(name = "id")Long id, @RequestBody cFamiliar familiar) {
        return ResponseEntity.ok(familiarService.updateFamiliar(id, familiar));
    }

}
