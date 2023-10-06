package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.TipoAlimento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class cAlimento extends cRecurso {

    @Column(length = 20)
    @Length(min = 1)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "tipo_alimento")
    private TipoAlimento tipoAlimento;
}
