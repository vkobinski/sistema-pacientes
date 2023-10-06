package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.jackson.JsonComponent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "endereco")
@ToString
@Getter
@Setter
public class cEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco;

    @Column(length = 45)
    @Length(min = 1)
    private String logradouro;

    @Column(length = 30)
    @Length(min = 1)
    private String bairro;

    @Column(length = 30)
    @Length(min = 1)
    private String complemento;

    @Column(length = 30, name = "ponto_referencia")
    private String pontoReferencia;

    @Column(length = 20, name = "nome_cidade")
    @Length(min = 1)
    private String nomeCidade;

    @Column(length = 20, name = "nome_estado")
    @Length(min = 1)
    private String nomeEstado;

    @Column(length = 8)
    @Length(min = 1)
    private String cep;

}
