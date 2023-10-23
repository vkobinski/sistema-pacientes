package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class cVisita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visita;

    @Column(nullable = false)
    private Date data_visita;

    @Column
    @ManyToMany
    private Set<cVoluntaria> voluntarias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "IDPaciente", nullable = false)
    private cPaciente paciente;

    @Column(name="DESC", columnDefinition="TEXT")
    private String descricaoVisita;

    private boolean ocorreu = false;

}
