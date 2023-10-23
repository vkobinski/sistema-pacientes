package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.deserializer.HospedeWrapper;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cHospede;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.repositories.TipoRefeicaoRepository;
import br.com.uepg.sistemapacientes.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospede")
public class HospedeController {

    private final HospedeService hospedeService;
    private final EnderecoRepository enderecoRepository;

    private final TipoRefeicaoRepository tipoRefeicaoRepository;

    @Autowired
    public HospedeController(HospedeService hospedeService, EnderecoRepository enderecoRepository, TipoRefeicaoRepository tipoRefeicaoRepository) {
        this.hospedeService = hospedeService;
        this.enderecoRepository = enderecoRepository;
        this.tipoRefeicaoRepository = tipoRefeicaoRepository;
    }


    @PostMapping
    public ResponseEntity<cHospede> criaHospede(@RequestBody HospedeWrapper wrapper) {

        cEndereco savedEndereco = enderecoRepository.save(wrapper.endereco);
        wrapper.hospede.setEndereco(savedEndereco);

        wrapper.hospede.setAtivo(true);

        wrapper.hospede.setData_registro(new Date(System.currentTimeMillis()));

        wrapper.hospede.setTipoRefeicao(tipoRefeicaoRepository.getTipoRefeicaoByNome(wrapper.hospede.getTipoRefeicao().getNome()));

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

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<cHospede> findHospedeByNome(@PathVariable(name = "nome") String nome) {
        Optional<cHospede> hospedeByNome = hospedeService.findHospedeByNome(nome);
        return hospedeByNome.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = "/cpf/{cpf}")
    public ResponseEntity<cHospede> findHospedeByCpf(@PathVariable(name = "cpf") String cpf) {
        Optional<cHospede> hospedeByCpf = hospedeService.findHospedeByCpf(cpf);
        return hospedeByCpf.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
