package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EstagioDoenca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEstagioDoenca;

    @Column(length = 30)
    private String nome;
}
