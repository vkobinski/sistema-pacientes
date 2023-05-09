package br.com.uepg.sistemapacientes.models;

import br.com.uepg.sistemapacientes.models.Enums.EstadoCivil;
import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import jakarta.persistence.*;
import lombok.ToString;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
public class cPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id_pessoa;

    @Column(length = 9)
    private String rg;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pessoa_endereco",
            joinColumns = { @JoinColumn(name = "pessoa_id") },
            inverseJoinColumns = { @JoinColumn(name = "endereco_id") })
    private Set<cEndereco> enderecos = new HashSet<>();

    @Column(length = 11)
    private String telefone;

    public void addEndereco(cEndereco endereco) {
        this.enderecos.add(endereco);
    }

    public Set<cEndereco> getEnderecos() {
        return enderecos;
    }

    @ManyToOne
    private cCurso curso;

    @ManyToOne
    @JoinColumn(name = "situacao_socioeconomica")
    private SituacaoSocioeconomica socioeconomica;

    @ManyToOne
    @JoinColumn(name = "estado_civil")
    private EstadoCivil estadoCivil;
}
