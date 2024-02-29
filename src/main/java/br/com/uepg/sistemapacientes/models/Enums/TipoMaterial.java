package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TipoMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTipoMaterial;

    @Column(length = 30, unique = true)
    private String nome;

    private int quantidadeTotal;

    private int quantidadeDoada;
}
