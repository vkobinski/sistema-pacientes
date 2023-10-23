package br.com.uepg.sistemapacientes.models;


import br.com.uepg.sistemapacientes.models.Enums.GrauParentesco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class cFamiliar extends cPessoa{

    @ManyToOne
    @JoinColumn(name = "ID_Atendido")
    private cAtendido atendido;

    @Length(min = 1)
    private String grauParentesco;

}

