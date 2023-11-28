package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.services.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;

@RestController
@RequestMapping("api/v1/relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public ResponseEntity<byte[]> getRelatorio() throws IOException {


        ByteArrayOutputStream stream = relatorioService.gerarRelatorio();

        String strDate = new SimpleDateFormat("dd-MM-yy").format(new java.sql.Date(Instant.now().toEpochMilli()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentDispositionFormData("attachment", "relatorio" + strDate + ".xlsx");

        return new ResponseEntity<>(stream.toByteArray(), headers, HttpStatus.OK);
    }

}
