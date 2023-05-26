package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id_pessoa;

    @Column(length = 9)
    private String rg;

    @Column
    private Boolean ativo;

    @Column(length = 11)
    private String cpf;

    @Column(length = 30)
    private String nome;

    @Column
    private Character sexo;

    @Column
    private Date dataNascimento;

    @Column
    private String profissao;

    @Column
    private Boolean redesSociais;

    @OneToOne
    private cEndereco endereco;

    @Column(length = 11)
    private String telefone;

    @ManyToOne
    private cCurso curso;

    @ManyToOne
    @JoinColumn(name = "situacao_socioeconomica")
    private SituacaoSocioeconomica socioeconomica;

    @Column
    private String estadoCivil;

    public cEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(cEndereco endereco) {
        this.endereco = endereco;
    }
}
