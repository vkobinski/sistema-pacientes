package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class cCurso {

    @Column(length = 20)
    @Length(min = 1)
    private String nome;

    @Column
    @Length(min = 1)
    private String descricao;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    private List<cPessoa> interessados;
}
