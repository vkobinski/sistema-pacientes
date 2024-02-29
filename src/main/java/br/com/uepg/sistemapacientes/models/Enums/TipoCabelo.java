package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class TipoCabelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTipoCabelo;

    @Column(length = 30, unique = true)
    @Length(min = 1)
    private String tipo;

    @Column(nullable = false)
    private int quantidadeTotal;

    @Column(nullable = false)
    private int quantidadeDoada;
}
