package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cPaciente extends cAtendido{

    @Column
    private int nivel_prioridade;

    public cPaciente(cAtendido atendido) {
        this.setId_pessoa(atendido.getId_pessoa());
        this.setRg(atendido.getRg());
        this.setAtivo(atendido.getAtivo());
        this.setCpf(atendido.getCpf());
        this.setNome(atendido.getNome());
        this.setSexo(atendido.getSexo());
        this.setDataNascimento(atendido.getDataNascimento());
        this.setProfissao(atendido.getProfissao());
        this.setRedesSociais(atendido.getRedesSociais());
        this.setCondicoesTrabalho(atendido.getCondicoesTrabalho());
        this.setEndereco(atendido.getEndereco());
        this.setTelefone(atendido.getTelefone());
        this.setCurso(atendido.getCurso());
        this.setData_registro(atendido.getData_registro());
        this.setSocioeconomica(atendido.getSocioeconomica());
       this.setEstadoCivil(atendido.getEstadoCivil());
        this.setEstagioDoenca(atendido.getEstagioDoenca());
        this.setData_registro(atendido.getData_registro());
        this.setTipo_cancro(atendido.getTipo_cancro());
        this.setData_falecimento(atendido.getData_falecimento());
    }
}
