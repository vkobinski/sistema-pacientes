package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.Especialidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class cProfissional {

    @Column(length = 30)
    @Length(min = 1)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "especialidade")
    private Especialidade especialidade;

    @Column
    private Timestamp dataCadastro;

    @Column
    private boolean ativo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profissional;
}
