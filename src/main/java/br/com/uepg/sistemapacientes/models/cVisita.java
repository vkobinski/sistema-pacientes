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

    @Column
    private Date data_visita;

    @Column
    @OneToMany
    private Set<cVoluntaria> voluntarias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "IDPaciente")
    private cPaciente paciente;

}
