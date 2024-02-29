package br.com.uepg.sistemapacientes.models.Enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class TipoRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTipoRecurso;

    @Length(min = 1)
    @Column(length = 30, unique = true)
    private String tipo;
}
