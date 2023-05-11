package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
public class cPaciente extends cAtendido{

    @Column
    private int nivel_prioridade;

}
