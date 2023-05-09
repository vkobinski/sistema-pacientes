package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@MappedSuperclass
@ToString
@Getter
@Setter
public class cRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_recurso;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "tipo_recurso")
    private TipoRecurso tipoRecurso;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_aquisicao;

    @Column
    private int quantidadeTotal;
    @Column
    private int quantidadeDoada;

}
