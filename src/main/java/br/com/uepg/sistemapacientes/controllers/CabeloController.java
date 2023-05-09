package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.services.CabeloService;
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
@RequestMapping("/api/v1/cabelo")
public class CabeloController {

    private final CabeloService cabeloService;
    private final TipoCabeloService tipoCabeloService;
    private  final TipoRecursoService tipoRecursoService;

    @Autowired
    public CabeloController(CabeloService cabeloService, TipoCabeloService tipoCabeloService, TipoRecursoService tipoRecursoService) {
        this.cabeloService = cabeloService;
        this.tipoCabeloService = tipoCabeloService;
        this.tipoRecursoService = tipoRecursoService;
    }


    @GetMapping
    public ResponseEntity<List<cCabelo>> getCabelos() {
        return ResponseEntity.ok(cabeloService.getCabelos());
    }

    @PostMapping
    public ResponseEntity<cCabelo> createCabelo(@RequestBody Map<String, Object> cabeloCampos) throws ParseException {
        cCabelo cabelo = new cCabelo();

        TipoCabelo tipoCabelo = tipoCabeloService.getTipoCabeloByTipo((String) cabeloCampos.get("cor"));
        cabelo.setTipoCabelo(tipoCabelo);

        cabelo.setComprimento(Integer.parseInt((String) cabeloCampos.get("comprimento")));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse((String) cabeloCampos.get("data_aquisicao"));

        Date data = new Date(date.getTime());

        cabelo.setQuantidade((Integer) cabeloCampos.get("quantidade"));
        cabelo.setData_aquisicao(data);

        TipoRecurso tipoRecurso = tipoRecursoService.getTipoRecursoByTipo((String) cabeloCampos.get("tipoRecurso"));
        cabelo.setTipoRecurso(tipoRecurso);

        return ResponseEntity.ok(cabeloService.createCabelo(cabelo));
    }
}
