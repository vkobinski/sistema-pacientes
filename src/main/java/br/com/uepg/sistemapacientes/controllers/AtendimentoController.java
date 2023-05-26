package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.deserializer.AtendimentoWrapper;
import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.models.cAtendimento;
import br.com.uepg.sistemapacientes.models.cHospede;
import br.com.uepg.sistemapacientes.models.cProfissional;
import br.com.uepg.sistemapacientes.services.AtendidoService;
import br.com.uepg.sistemapacientes.services.AtendimentoService;
import br.com.uepg.sistemapacientes.services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atendimento")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;
    private final ProfissionalService profissionalService;
    private final AtendidoService atendidoService;

    @Autowired
    public AtendimentoController(AtendimentoService atendimentoService, ProfissionalService profissionalService, AtendidoService atendidoService) {
        this.atendimentoService = atendimentoService;
        this.profissionalService = profissionalService;
        this.atendidoService = atendidoService;
    }


    @PostMapping
    public ResponseEntity<cAtendimento> criaAtendimento(@RequestBody AtendimentoWrapper wrapper) {
        cProfissional profissionalById = profissionalService.findProfissionalById(wrapper.getProfissional());
        cAtendido atendidoById = atendidoService.findAtendidoById(wrapper.getAtendido());

        cAtendimento atendimento = new cAtendimento();

        atendimento.setAtendido(atendidoById);
        atendimento.setProfissional(profissionalById);
        atendimento.setData(wrapper.getData());

        atendimento = atendimentoService.criaAtendimento(atendimento);

        return ResponseEntity.ok(atendimento);
    }

    @GetMapping
    public ResponseEntity<List<cAtendimento>> getAtendimentos() {
        return ResponseEntity.ok(atendimentoService.getAtendimentos());
    }


}
