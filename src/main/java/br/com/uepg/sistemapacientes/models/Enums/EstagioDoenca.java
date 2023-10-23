package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class EstagioDoenca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEstagioDoenca;

    @Column(length = 30)
    @Length(min = 1)
    private String nome;

    private boolean ativo = true;
}
