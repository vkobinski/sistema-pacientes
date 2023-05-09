package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long idEstadoCivil;

    @Column(length = 30)
    private String nome;
}
