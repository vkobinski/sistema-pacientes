package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class cVoluntaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_voluntaria;

    @Length(min = 1)
    @Column(length = 30)
    private String nome;

    @Length(min = 1)
    @Column(length = 40)
    private String contato;

    @Length(min = 1)
    @Column(length = 40)
    private String setor;


}
