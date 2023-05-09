package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class cCurso {

    @Column(length = 20)
    private String nome;

    @Column
    private String descricao;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    private List<cPessoa> interessados;
}
