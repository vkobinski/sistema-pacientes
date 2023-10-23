package br.com.uepg.sistemapacientes.models;


import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class cAtendido extends cPessoa{

    @Column
    private Date data_falecimento;

    @ManyToOne
    @JoinColumn(name = "estagio_doenca")
    private EstagioDoenca estagioDoenca;

    @Column
    private String tipo_cancro;

    @ManyToMany(mappedBy = "atendido", fetch = FetchType.LAZY)
    private Set<cEmprestimo> emprestimos;
}

