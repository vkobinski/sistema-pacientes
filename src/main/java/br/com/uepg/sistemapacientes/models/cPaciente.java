package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cPaciente extends cAtendido{

    @Column
    private int nivel_prioridade;

}
