package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
public class cEmprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_emprestimo;

    @ManyToOne
    private cEquipamento equipamento;

    @Column
    private Date data_emprestimo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "atendido_emprestimo",
            joinColumns = { @JoinColumn(name = "emprestimo_id") },
            inverseJoinColumns = { @JoinColumn(name = "atendido_id") })
    private Set<cAtendido> atendido;
}
