package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class SituacaoSocioeconomica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSituacaoSocioeconomica;

    @Column(length = 30)
    private String nome;
}
