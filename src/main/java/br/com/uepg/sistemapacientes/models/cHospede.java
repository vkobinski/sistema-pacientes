package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class cHospede extends cAtendido{

    @Column
    private Timestamp dataEntrada;

    @Column
    private Timestamp dataSaida;

    @ManyToOne
    @JoinColumn(name = "quarto_hospedagem")
    private QuartoHospedagem quartoHospedagem;

    @Column
    private String tratamento;

    @Column
    private Time horarioTratamento;

    @ManyToOne
    @JoinColumn(name = "tipo_refeicao")
    private TipoRefeicao tipoRefeicao;

}
