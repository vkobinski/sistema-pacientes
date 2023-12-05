package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import br.com.uepg.sistemapacientes.models.Enums.TipoMaterial;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.models.cMaterial;
import br.com.uepg.sistemapacientes.repositories.TipoMaterialRepository;
import br.com.uepg.sistemapacientes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/material")
public class MaterialController {

    private final MaterialService materialService;
    private final TipoMaterialService tipoMaterialService;
    private  final TipoRecursoService tipoRecursoService;

    @Autowired
    public MaterialController(MaterialService materialService, TipoMaterialService tipoMaterialService, TipoRecursoService tipoRecursoService) {
        this.materialService = materialService;
        this.tipoMaterialService = tipoMaterialService;
        this.tipoRecursoService = tipoRecursoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<cMaterial> getById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.getById(id));
    }


    @GetMapping
    public ResponseEntity<List<cMaterial>> getMateriais() {
        return ResponseEntity.ok(materialService.getMateriais());
    }

    @PostMapping
    public ResponseEntity<cMaterial> createMaterial(@RequestBody Map<String, Object> materialCampos) throws ParseException {
        cMaterial material = new cMaterial();

        TipoMaterial tipoMaterial = tipoMaterialService.getTipoMaterialByNome((String) materialCampos.get("tipoMaterial"));
        material.setTipoMaterial(tipoMaterial);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse((String) materialCampos.get("data_aquisicao"));

        Date data = new Date(date.getTime());

        material.setQuantidade((Integer) materialCampos.get("quantidade"));
        material.setData_aquisicao(data);

        TipoRecurso tipoRecurso = tipoRecursoService.getTipoRecursoByTipo((String) materialCampos.get("tipoRecurso"));
        material.setTipoRecurso(tipoRecurso);

        return ResponseEntity.ok(materialService.createMaterial(material));
    }
}
