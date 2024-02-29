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

    @Column
    private String tratamento;

    @ManyToMany(mappedBy = "atendido", fetch = FetchType.LAZY)
    private Set<cEmprestimo> emprestimos;

    public cAtendido(cPessoa pessoa) {
        this.setAtivo(pessoa.getAtivo());
        this.setRg(pessoa.getRg());
        this.setCpf(pessoa.getCpf());
        this.setNome(pessoa.getNome());
        this.setSexo(pessoa.getSexo());
        this.setDataNascimento(pessoa.getDataNascimento());
        this.setProfissao(pessoa.getProfissao());
        this.setRedesSociais(pessoa.getRedesSociais());
        this.setCondicoesTrabalho(pessoa.getCondicoesTrabalho());
        this.setTelefone(pessoa.getTelefone());
        this.setSocioeconomica(pessoa.getSocioeconomica());
        this.setEstadoCivil(pessoa.getEstadoCivil());
        this.setEndereco(pessoa.getEndereco());
        this.setData_registro(pessoa.getData_registro());
        this.setEndereco(pessoa.getEndereco());
    }
}

