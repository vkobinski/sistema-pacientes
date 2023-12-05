package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoacao;

    @ManyToOne
    @JoinColumn(name = "IDAtendido")
    private cAtendido atendido;

    @OneToOne
    @JoinColumn(name = "IDRecurso")
    private cRecurso recurso;

    @Column
    private Date dataDoacao;

}
