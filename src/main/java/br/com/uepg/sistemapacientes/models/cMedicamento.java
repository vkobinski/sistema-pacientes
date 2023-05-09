package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class cMedicamento extends cRecurso {

    @Column(length = 30)
    private String nome;
    @Column
    private Double preco;
    @Column(length = 30)
    private String farmacia_compra;
}
