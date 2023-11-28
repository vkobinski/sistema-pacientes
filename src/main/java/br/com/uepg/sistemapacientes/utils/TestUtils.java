package br.com.uepg.sistemapacientes.utils;

import br.com.uepg.sistemapacientes.models.*;
import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import br.com.uepg.sistemapacientes.repositories.*;
import com.github.javafaker.Faker;

import java.sql.Time;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TestUtils {
    private final Faker faker = new Faker();

    private final FamiliarRepository familiarRepository;
    private final HospedeRepository hospedeRepository;
    private final EnderecoRepository enderecoRepository;
    private final PacienteRepository pacienteRepository;
    private final CursoRepository cursoRepository;
    private final SituacaoSocioeconomicaRepository situacaoSocioeconomicaRepository;
    private final EstagioDoencaRepository estagioDoencaRepository;
    private final EmprestimoRepository emprestimoRepository;
    private final QuartoHospedagemRepository quartoHospedagemRepository;
    private final TipoRefeicaoRepository tipoRefeicaoRepository;

    public TestUtils(FamiliarRepository familiarRepository, HospedeRepository hospedeRepository, EnderecoRepository enderecoRepository, PacienteRepository pacienteRepository, CursoRepository cursoRepository, SituacaoSocioeconomicaRepository situacaoSocioeconomicaRepository, EstagioDoencaRepository estagioDoencaRepository, EmprestimoRepository emprestimoRepository, QuartoHospedagemRepository quartoHospedagemRepository, TipoRefeicaoRepository tipoRefeicaoRepository) {
        this.familiarRepository = familiarRepository;
        this.hospedeRepository = hospedeRepository;
        this.enderecoRepository = enderecoRepository;
        this.pacienteRepository = pacienteRepository;
        this.cursoRepository = cursoRepository;
        this.situacaoSocioeconomicaRepository = situacaoSocioeconomicaRepository;
        this.estagioDoencaRepository = estagioDoencaRepository;
        this.emprestimoRepository = emprestimoRepository;
        this.quartoHospedagemRepository = quartoHospedagemRepository;
        this.tipoRefeicaoRepository = tipoRefeicaoRepository;
    }

    public cEndereco generateEndereco() {
        cEndereco endereco = new cEndereco();

        endereco.setLogradouro(faker.address().streetAddress());
        endereco.setBairro(faker.address().secondaryAddress());
        endereco.setComplemento(faker.address().buildingNumber());
        endereco.setPontoReferencia(faker.address().lastName());
        endereco.setNomeCidade(faker.address().cityName());
        endereco.setNomeEstado(faker.address().state());
        endereco.setCep("1234567");

        enderecoRepository.save(endereco);
        return endereco;
    }

    public cCurso generateCurso() {
        cCurso curso = new cCurso();

        curso.setNome(faker.job().title());
        curso.setDescricao(faker.job().keySkills());
        curso.setInteressados(null);

        cursoRepository.save(curso);
        return curso;
    }

    public cPessoa generatePessoa() {

        cPessoa pessoa = new cPessoa();

        pessoa.setAtivo(true);
        pessoa.setRg(faker.number().digits(12));
        pessoa.setCpf(faker.number().digits(11));
        pessoa.setNome(faker.name().fullName());
        pessoa.setSexo(faker.options().option("M", "F").charAt(0));
        pessoa.setDataNascimento(new java.sql.Date(faker.date().birthday().getTime()));
        pessoa.setProfissao(faker.job().title());
        pessoa.setRedesSociais(faker.random().nextBoolean());
        pessoa.setCondicoesTrabalho(faker.lorem().sentence());
        pessoa.setTelefone(faker.phoneNumber().cellPhone().substring(3));
        pessoa.setSocioeconomica(situacaoSocioeconomicaRepository.findAll().get(faker.number().numberBetween(0,2)));
        pessoa.setEstadoCivil(faker.hacker().abbreviation());
        pessoa.setEndereco(generateEndereco());
        pessoa.setData_registro(new java.sql.Date(Instant.now().toEpochMilli()));

        return pessoa;

    }

    public java.sql.Date getDate(java.util.Date utilDate) {

        return new java.sql.Date(utilDate.getTime());
    }

    public EstagioDoenca generateEstagioDoenca() {

        return estagioDoencaRepository.findAll().get(faker.number().numberBetween(0,4));
    }

    public cAtendido generateAtendido() {
        cAtendido atendido = new cAtendido(generatePessoa());

        atendido.setData_falecimento(faker.options().option(getDate(faker.date().future(4, TimeUnit.DAYS)), null));
        atendido.setEstagioDoenca(generateEstagioDoenca());
        atendido.setTipo_cancro(faker.ancient().hero());
        atendido.setEmprestimos(null);

        return atendido;
    }

    public cPaciente generateRandomPaciente() {

        cPaciente paciente = new cPaciente(generateAtendido());

        paciente.setNivel_prioridade(faker.number().numberBetween(1, 10));

        pacienteRepository.save(paciente);
        return paciente;
    }

    public cFamiliar generateRandomFamiliar() {

        cFamiliar familiar = new cFamiliar(generatePessoa());

        familiar.setAtendido(generateRandomPaciente());
        familiar.setGrauParentesco(faker.lorem().characters(2, 4));

        familiarRepository.save(familiar);
        return familiar;
    }

    public QuartoHospedagem generateQuartoHospedagem() {
        return quartoHospedagemRepository.findAll().get(faker.number().numberBetween(0,19));

    }

    public TipoRefeicao generateTipoRefeicao() {
        return tipoRefeicaoRepository.findAll().get(faker.number().numberBetween(0,4));

    }


    public cHospede generateRandomHospede() {

        cHospede hospede = new cHospede(generateAtendido());

        hospede.setDataEntrada(new java.sql.Date(faker.date().birthday().getTime()));
        hospede.setDataSaida(new java.sql.Date(faker.date().birthday().getTime()));
        hospede.setQuartoHospedagem(generateQuartoHospedagem());
        hospede.setTratamento(faker.ancient().god());
        hospede.setHorarioTratamento(new Time(Instant.now().getEpochSecond()));
        hospede.setTipoRefeicao(generateTipoRefeicao());

        hospedeRepository.save(hospede);

        return hospede;
    }
}