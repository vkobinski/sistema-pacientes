package br.com.uepg.sistemapacientes.models;


import br.com.uepg.sistemapacientes.models.Enums.GrauParentesco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class cFamiliar extends cPessoa{

    @ManyToOne
    @JoinColumn(name = "ID_Atendido")
    private cAtendido atendido;

    private String grauParentesco;

}

