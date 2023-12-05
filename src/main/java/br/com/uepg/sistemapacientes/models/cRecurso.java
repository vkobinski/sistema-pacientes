package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class cRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id_recurso;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "tipo_recurso")
    private TipoRecurso tipoRecurso;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_aquisicao;

    @Column(nullable = false)
    private int quantidadeTotal;
    @Column(nullable = false)
    private int quantidadeDoada;

}
