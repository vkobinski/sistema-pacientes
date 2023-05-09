package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.TipoMaterial;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class cMaterial extends cRecurso {

    @ManyToOne
    @JoinColumn(name = "tipo_material")
    private TipoMaterial tipoMaterial;
}
