package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEspecialidade;

    @Column(length = 30, unique = true)
    @Length(min = 1)
    private String nomeEspecialidade;
}
