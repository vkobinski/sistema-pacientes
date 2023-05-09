package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;

@Entity
public class cEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipamento;

    @Column(length = 30)
    private String nome;

    @Column
    private Integer quantidadeTotal;

    @Column
    private Integer quantidadeDisponivel;

}
