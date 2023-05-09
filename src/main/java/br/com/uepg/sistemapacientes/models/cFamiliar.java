package br.com.uepg.sistemapacientes.models;


import br.com.uepg.sistemapacientes.models.Enums.Escolaridade;
import br.com.uepg.sistemapacientes.models.Enums.GrauParentesco;
import jakarta.persistence.*;

@Entity
public class cFamiliar extends cPessoa{

    @ManyToOne
    @JoinColumn(name = "ID_Atendido")
    private cAtendido atendido;

    @ManyToOne
    @JoinColumn(name = "grau_parentesco")
    private GrauParentesco grauParentesco;

    @ManyToOne
    @JoinColumn(name = "escolaridade")
    private Escolaridade escolaridade;
}

