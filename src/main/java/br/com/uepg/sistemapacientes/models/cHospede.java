package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class cHospede extends cAtendido{

    @Column
    private Date dataEntrada;

    @Column
    private Date dataSaida;

    @ManyToOne
    @JoinColumn(name = "quarto_hospedagem")
    private QuartoHospedagem quartoHospedagem;

    @Column
    private Time horarioTratamento;

    @ManyToOne
    @JoinColumn(name = "tipo_refeicao")
    private TipoRefeicao tipoRefeicao;

    public cHospede(cAtendido atendido) {
        this.setTratamento(atendido.getTratamento());
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
