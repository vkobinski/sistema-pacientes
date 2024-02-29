package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstagioDoenca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEstagioDoenca;

    @Column(length = 30, unique = true)
    @Length(min = 1)
    private String nome;

    private boolean ativo = true;
}
