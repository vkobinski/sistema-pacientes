package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.deserializer.HospedeWrapper;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cHospede;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hospede")
public class HospedeController {

    private final HospedeService hospedeService;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public HospedeController(HospedeService hospedeService, EnderecoRepository enderecoRepository) {
        this.hospedeService = hospedeService;
        this.enderecoRepository = enderecoRepository;
    }


    @PostMapping
    public ResponseEntity<cHospede> criaHospede(@RequestBody HospedeWrapper wrapper) {

        System.out.println(wrapper.hospede);

        cEndereco savedEndereco = enderecoRepository.save(wrapper.endereco);
        wrapper.hospede.setEndereco(savedEndereco);

        wrapper.hospede.setAtivo(true);

        wrapper.hospede.setData_registro(new Date(System.currentTimeMillis()));
        cHospede hospede = hospedeService.criaHospede(wrapper.hospede);

        return ResponseEntity.ok(hospede);
    }

    @GetMapping
    public ResponseEntity<List<cHospede>> getHospedes() {
        return ResponseEntity.ok(hospedeService.getHospedes());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<cHospede> getHospedeById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(hospedeService.findHospedeById(id));
    }


}
