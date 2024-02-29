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
public class TipoRefeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTipoRefeicao;

    @Length(min = 1)
    @Column(length = 30, unique = true)
    private String nome;
}
