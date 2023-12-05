package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class cAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Atendimento;

    @Column
    private Timestamp data;

    @ManyToOne
    @JoinColumn(name = "IDProfissional")
    private cProfissional profissional;

    @OneToOne
    @JoinColumn(name = "IDAtendido")
    private cAtendido atendido;
}
