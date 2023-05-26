package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.deserializer.PacienteWrapper;
import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.services.AtendidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/atendido")
public class AtendidoController {

    private final AtendidoService atendidoService;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public AtendidoController(AtendidoService atendidoService, EnderecoRepository enderecoRepository) {
        this.atendidoService = atendidoService;
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public ResponseEntity<List<cAtendido>> getAtendidos() {
        return ResponseEntity.ok(atendidoService.getAtendidos());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<cAtendido> findAtendidoByNome(@PathVariable(name = "nome") String nome) {
        return ResponseEntity.ok(atendidoService.findAtendidoByNome(nome));
    }

    @GetMapping("/rg/{rg}")
    public ResponseEntity<cAtendido> findAtendidoByRg(@PathVariable(name = "rg") String rg) {
        return ResponseEntity.ok(atendidoService.findAtendidoByRg(rg));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<cAtendido> findAtendidoByCpf(@PathVariable(name = "cpf") String cpf) {
        return ResponseEntity.ok(atendidoService.findAtendidoByCpf(cpf));
    }

}
