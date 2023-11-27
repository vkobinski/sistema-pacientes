package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class cPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id_pessoa;

    @Length(min = 1)
    @Column(length = 12, nullable = false)
    private String rg;

    @Column(nullable = false)
    private Boolean ativo;

    @Length(min = 1)
    @Column(length = 11, unique = true, nullable = false, updatable = false)
    private String cpf;

    @Length(min = 1)
    @Column(length = 30, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Character sexo;

    @Column(nullable = false)
    private Date dataNascimento;

    @Length(min = 1)
    @Column(nullable = false)
    private String profissao;

    @Column(nullable = false)
    private Boolean redesSociais;

    @Column(name="DESC", columnDefinition="TEXT")
    private String condicoesTrabalho;

    @Getter
    @OneToOne
    private cEndereco endereco;

    @Column(length = 11)
    private String telefone;

    @ManyToOne
    private cCurso curso;

    @Column
    private Date data_registro;

    @ManyToOne
    @JoinColumn(name = "situacao_socioeconomica")
    private SituacaoSocioeconomica socioeconomica;
    @Length(min = 1)
    @Column
    private String estadoCivil;

    public void setEndereco(cEndereco endereco) {
        this.endereco = endereco;
    }
}
