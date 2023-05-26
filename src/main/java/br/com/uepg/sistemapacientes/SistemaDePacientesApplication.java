package br.com.uepg.sistemapacientes;

import br.com.uepg.sistemapacientes.models.Enums.*;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.models.cPessoa;
import br.com.uepg.sistemapacientes.repositories.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SistemaDePacientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePacientesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository, TipoRecursoRepository recursoRepository, TipoMaterialRepository tipoMaterialRepository, TipoCabeloRepository tipoCabeloRepository,
							TipoAlimentoRepository tipoAlimentoRepository, EspecialidadeRepository especialidadeRepository, PacienteRepository pacienteRepository, SituacaoSocioeconomicaRepository situacaoSocioeconomicaRepository,
						   EstagioDoencaRepository estagioDoencaRepository, QuartoHospedagemRepository quartoHospedagemRepository, TipoRefeicaoRepository tipoRefeicaoRepository) {
		return (args) -> {


			cEndereco endereco = new cEndereco();
			enderecoRepository.save(endereco);

			cPessoa pessoa = new cPessoa();
			pessoa.setEndereco(endereco);
			pessoaRepository.save(pessoa);

			List<String> tipos = Arrays.asList("Medicamento", "Roupa", "Material", "Cabelo", "Alimento");

			for(String tipo : tipos) {
				TipoRecurso tipoRecurso = new TipoRecurso();
				tipoRecurso.setTipo(tipo);

				recursoRepository.save(tipoRecurso);
			}

			List<String> tiposCabelo = Arrays.asList("Ruivo", "Moreno", "Loiro");

			for(String tipo : tiposCabelo) {
				TipoCabelo tipoCabelo = new TipoCabelo();
				tipoCabelo.setTipo(tipo);

				tipoCabeloRepository.save(tipoCabelo);
			}

			List<String> tiposMaterial = Arrays.asList("Cadeira de Rodas", "Cama Médica");

			for(String tipo : tiposMaterial) {
				TipoMaterial tipoMaterial = new TipoMaterial();
				tipoMaterial.setNome(tipo);

				tipoMaterialRepository.save(tipoMaterial);
			}

			List<String> tiposAlimentos = Arrays.asList("Arroz", "Feijão");

			for(String tipo : tiposAlimentos) {
				TipoAlimento tipoAlimento = new TipoAlimento();
				tipoAlimento.setNome(tipo);

				tipoAlimentoRepository.save(tipoAlimento);
			}

			List<String> especialidades = Arrays.asList("Médico", "Dentista");

			for(String tipo : especialidades) {
				Especialidade especialidade = new Especialidade();
				especialidade.setNomeEspecialidade(tipo);

				especialidadeRepository.save(especialidade);
			}

			cPaciente paciente = new cPaciente();
			paciente.setNome("Maria");
			pacienteRepository.save(paciente);

			paciente = new cPaciente();
			paciente.setNome("Pedro");
			pacienteRepository.save(paciente);

			SituacaoSocioeconomica socioeconomica = new SituacaoSocioeconomica();
			socioeconomica.setNome("Teste");
			situacaoSocioeconomicaRepository.save(socioeconomica);

			EstagioDoenca estagioDoenca = new EstagioDoenca();
			estagioDoenca.setNome("Teste");
			estagioDoencaRepository.save(estagioDoenca);

			QuartoHospedagem quartoHospedagem = new QuartoHospedagem();
			quartoHospedagem.setNome("15");
			quartoHospedagemRepository.save(quartoHospedagem);

			TipoRefeicao tipoRefeicao = new TipoRefeicao();
			tipoRefeicao.setNome("Vegetariana");
			tipoRefeicaoRepository.save(tipoRefeicao);
		};
	}
}
