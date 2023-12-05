package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class RelatorioService {

    private final PacienteService pacienteService;
    private final FamiliarService familiarService;
    private final HospedeService hospedeService;
    private final DoacaoService doacaoService;
    
    Workbook wb;


    @Autowired
    public RelatorioService(PacienteService pacienteService, FamiliarService familiarService, HospedeService hospedeService, DoacaoService doacaoService) {
        this.pacienteService = pacienteService;
        this.familiarService = familiarService;
        this.hospedeService = hospedeService;
        this.doacaoService = doacaoService;
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

    public boolean checkThisMonth(java.sql.Date date1, java.sql.Date date2) {

        if(date1 == null || date2 == null) return false;

        return date1.getMonth() == date2.getMonth() && date1.getYear() == date2.getYear();
    }

    public void getNovosAtendidos() {
        List<cPaciente> pacientes = pacienteService.getPacientes();
        List<cHospede> hospedes = hospedeService.getHospedes();
        List<cFamiliar> familiares = familiarService.getFamiliares();

        Sheet sheet = wb.createSheet("Novos Pacientes");

        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("Data");
        titleRow.createCell(1).setCellValue("Paciente");

        List<cPessoa> pessoas = new ArrayList<>();
        pessoas.addAll(pacientes);
        pessoas.addAll(hospedes);
        pessoas.addAll(familiares);

        List<cPessoa> pessoasData = new ArrayList<>();


        java.sql.Date atual = new java.sql.Date(Instant.now().toEpochMilli());

        pessoas.forEach(pessoa -> {
            if(checkThisMonth(pessoa.getData_registro(),atual)) {
                pessoasData.add(pessoa);
            }
        });

        pessoasData.forEach( s -> {
            int iRow = sheet.getLastRowNum() + 1;

            Row curRow = sheet.createRow(iRow);

            String strDate = new SimpleDateFormat("dd-MM-yy").format(s.getData_registro());

            curRow.createCell(0).setCellValue(strDate);
            curRow.createCell(1).setCellValue(s.getNome());

        });

    }

    public void getFalecimentos() {
        List<cPaciente> pacientes = pacienteService.getPacientes();
        List<cHospede> hospedes = hospedeService.getHospedes();

        Sheet sheet = wb.createSheet("Falecimentos");

        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("Data");
        titleRow.createCell(1).setCellValue("Paciente");

        List<cPessoa> pessoas = new ArrayList<>();

        java.sql.Date atual = new java.sql.Date(Instant.now().toEpochMilli());

        pacientes.forEach(paciente -> {
            if(checkThisMonth(paciente.getData_falecimento(),atual)) {
                pessoas.add(paciente);
            }
        });

        hospedes.forEach(paciente -> {
            if(checkThisMonth(paciente.getData_falecimento(),atual)) {
                pessoas.add(paciente);
            }
        });

        pessoas.forEach( s -> {
            int iRow = sheet.getLastRowNum() + 1;

            Row curRow = sheet.createRow(iRow);

            String strDate = new SimpleDateFormat("dd-MM-yy").format(s.getData_registro());

            curRow.createCell(0).setCellValue(strDate);
            curRow.createCell(1).setCellValue(s.getNome());

        });

    }

    public void getDoacoes() {
        List<Doacao> doacoes = doacaoService.getAll();

        Sheet sheet = wb.createSheet("Doações");

        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("Data");
        titleRow.createCell(1).setCellValue("Atendido");
        titleRow.createCell(2).setCellValue("Tipo Recurso");


        java.sql.Date atual = new java.sql.Date(Instant.now().toEpochMilli());

        doacoes.removeIf(doacao -> !checkThisMonth(doacao.getDataDoacao(), atual));

        doacoes.forEach( s -> {
            int iRow = sheet.getLastRowNum() + 1;

            Row curRow = sheet.createRow(iRow);

            String strDate = new SimpleDateFormat("dd-MM-yy").format(s.getDataDoacao());

            curRow.createCell(0).setCellValue(strDate);
            curRow.createCell(1).setCellValue(s.getAtendido().getNome());
            curRow.createCell(2).setCellValue(s.getRecurso().getTipoRecurso().getTipo());
        });
    }



    public ByteArrayOutputStream gerarRelatorio() {

        getNumeroAtendidos();
        getTipoCancro();
        getSexo();
        getNovosAtendidos();
        getFalecimentos();
        getDoacoes();

        try (ByteArrayOutputStream fileOut = new ByteArrayOutputStream()) {
            wb.write(fileOut);
            wb = new HSSFWorkbook();
            return fileOut;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
