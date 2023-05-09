package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class cCabelo extends cRecurso {
    @ManyToOne
    @JoinColumn(name = "tipo_cabelo")
    private TipoCabelo tipoCabelo;

    @Column
    private int comprimento;
}
