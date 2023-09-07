package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEspecialidade;

    @Column(length = 30)
    private String nomeEspecialidade;
}
