package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class cVoluntaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_voluntaria;

    @Column(length = 30)
    private String nome;
}
