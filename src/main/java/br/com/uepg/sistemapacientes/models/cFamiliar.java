package br.com.uepg.sistemapacientes.models;


import br.com.uepg.sistemapacientes.models.Enums.GrauParentesco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cFamiliar extends cPessoa{

    @ManyToOne
    @JoinColumn(name = "ID_Atendido")
    private cAtendido atendido;

    @Length(min = 1)
    private String grauParentesco;

    public cFamiliar(cPessoa pessoa) {
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

