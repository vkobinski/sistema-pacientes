package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TipoCabelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTipoCabelo;


    @Column(length = 30)
    private String tipo;

    @Column
    private int quantidadeTotal;

    @Column
    private int quantidadeDoada;
}
