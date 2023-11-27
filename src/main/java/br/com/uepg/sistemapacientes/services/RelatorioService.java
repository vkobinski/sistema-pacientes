package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cFamiliar;
import br.com.uepg.sistemapacientes.models.cHospede;
import br.com.uepg.sistemapacientes.models.cPaciente;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class RelatorioService {

    private final PacienteService pacienteService;
    private final FamiliarService familiarService;
    private final HospedeService hospedeService;
    
    Workbook wb;


    @Autowired
    public RelatorioService(PacienteService pacienteService, FamiliarService familiarService, HospedeService hospedeService) {
        this.pacienteService = pacienteService;
        this.familiarService = familiarService;
        this.hospedeService = hospedeService;
        wb = new HSSFWorkbook();
    }

    public void getNumeroAtendidos() {
        long pacCount = pacienteService.countPaciente();
        long hosCount = hospedeService.countHospede();
        long famCount = familiarService.countFamiliar();

        Sheet sheet = wb.createSheet("Contagem");

        Row titleCountRow = sheet.createRow(0);
        titleCountRow.createCell(0).setCellValue("Pacientes");
        titleCountRow.createCell(1).setCellValue("Hospédes");
        titleCountRow.createCell(2).setCellValue("Familiares");

        Row valueCountRow = sheet.createRow(1);
        valueCountRow.createCell(0).setCellValue(pacCount);
        valueCountRow.createCell(1).setCellValue(hosCount);
        valueCountRow.createCell(2).setCellValue(famCount);

    }

    public void getSexo() {
        List<cPaciente> pacientes = pacienteService.getPacientes();
        List<cHospede> hospedes = hospedeService.getHospedes();
        List<cFamiliar> familiares = familiarService.getFamiliares();

        Sheet sheet = wb.createSheet("Sexos");

        Row titleRow = sheet.createRow(0);
        Row valueRow = sheet.createRow(1);

        titleRow.createCell(0).setCellValue("Homens");
        titleRow.createCell(1).setCellValue("Mulheres");

        HashMap<Character, Long> sexos = new HashMap<>();

        pacientes.forEach(paciente -> {
            char sexo = paciente.getSexo();
            sexos.compute(sexo, (c, aLong) -> (aLong == null) ? 1 : aLong + 1);
        });
        familiares.forEach(paciente -> {
            char sexo = paciente.getSexo();
            sexos.compute(sexo, (c, aLong) -> (aLong == null) ? 1 : aLong + 1);
        });
        hospedes.forEach(paciente -> {
            char sexo = paciente.getSexo();
            sexos.compute(sexo, (c, aLong) -> (aLong == null) ? 1 : aLong + 1);
        });

        valueRow.createCell(0).setCellValue(sexos.get('M'));
        valueRow.createCell(1).setCellValue(sexos.get('F'));


    }

    public void getTipoCancro() {
        List<cPaciente> pacientes = pacienteService.getPacientes();
        List<cHospede> hospedes = hospedeService.getHospedes();

        Sheet sheet = wb.createSheet("Tipo Cancro");

        Row titleRow = sheet.createRow(0);
        Row valueRow = sheet.createRow(1);

        HashMap<String, Long> tipoCancros = new HashMap<>();

        pacientes.forEach(paciente -> {
            String tipoCancro = paciente.getTipo_cancro();
            tipoCancros.compute(tipoCancro, (s, aLong) -> (aLong == null) ? 1 : aLong + 1);
        });

        hospedes.forEach(hospede -> {
            String tipoCancro = hospede.getTipo_cancro();
            tipoCancros.compute(tipoCancro, (s, aLong) -> (aLong == null) ? 1 : aLong + 1);
        });

        tipoCancros.forEach((s, aLong) -> {

            short i = titleRow.getLastCellNum();
            if(i == -1) i = 0;

            titleRow.createCell(i).setCellValue(s);
            valueRow.createCell(i).setCellValue(aLong);

            i++;
        });

    }

    public ByteArrayOutputStream gerarRelatorio() {

        getNumeroAtendidos();
        getTipoCancro();
        getSexo();

        try (ByteArrayOutputStream fileOut = new ByteArrayOutputStream()) {
            wb.write(fileOut);
            return fileOut;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
