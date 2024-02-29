package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuartoHospedagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idQuartoHospedagem;

    @Column(length = 30, unique = true)
    private String nome;
}
