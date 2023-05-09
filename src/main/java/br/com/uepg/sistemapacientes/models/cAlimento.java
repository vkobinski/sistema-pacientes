package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.TipoAlimento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class cAlimento extends cRecurso {

    @Column(length = 20)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "tipo_alimento")
    private TipoAlimento tipoAlimento;
}
