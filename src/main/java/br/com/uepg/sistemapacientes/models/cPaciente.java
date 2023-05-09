package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.sql.Date;
import java.sql.Time;

@Entity
public class cPaciente extends cAtendido{

    @Column
    private int nivel_prioridade;

}
