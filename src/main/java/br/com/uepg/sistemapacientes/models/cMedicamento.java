package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class cMedicamento extends cRecurso {

    @Length(min = 1)
    @Column(length = 30)
    private String nome;
    @Column(nullable = false)
    private Double preco;
    @Column(length = 30)
    @Length(min = 1)
    private String farmacia_compra;
}
