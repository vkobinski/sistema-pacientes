package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.models.cRoupa;
import br.com.uepg.sistemapacientes.services.CabeloService;
import br.com.uepg.sistemapacientes.services.RoupaService;
import br.com.uepg.sistemapacientes.services.TipoCabeloService;
import br.com.uepg.sistemapacientes.services.TipoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/roupa")
public class RoupaController {

    private final RoupaService roupaService;
    private  final TipoRecursoService tipoRecursoService;

    @Autowired
    public RoupaController(RoupaService roupaService, TipoRecursoService tipoRecursoService) {
        this.roupaService = roupaService;
        this.tipoRecursoService = tipoRecursoService;
    }


    @GetMapping
    public ResponseEntity<List<cRoupa>> getRoupas() {
        return ResponseEntity.ok(roupaService.getRoupas());
    }

    @PostMapping
    public ResponseEntity<cRoupa> createRoupa(@RequestBody Map<String, Object> roupaCampos) throws ParseException {
        cRoupa roupa = new cRoupa();

        roupa.setKit(Integer.parseInt((String)roupaCampos.get("kit")));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse((String) roupaCampos.get("data_aquisicao"));

        Date data = new Date(date.getTime());

        roupa.setQuantidade((Integer) roupaCampos.get("quantidade"));
        roupa.setData_aquisicao(data);

        TipoRecurso tipoRecurso = tipoRecursoService.getTipoRecursoByTipo((String) roupaCampos.get("tipoRecurso"));
        roupa.setTipoRecurso(tipoRecurso);

        return ResponseEntity.ok(roupaService.createRoupa(roupa));
    }
}
