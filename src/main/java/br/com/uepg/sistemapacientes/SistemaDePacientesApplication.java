package br.com.uepg.sistemapacientes;

import br.com.uepg.sistemapacientes.models.Enums.*;
import br.com.uepg.sistemapacientes.repositories.*;
import br.com.uepg.sistemapacientes.utils.TestUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SistemaDePacientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePacientesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository, TipoRecursoRepository recursoRepository, TipoMaterialRepository tipoMaterialRepository, TipoCabeloRepository tipoCabeloRepository,
							TipoAlimentoRepository tipoAlimentoRepository, EspecialidadeRepository especialidadeRepository, PacienteRepository pacienteRepository, HospedeRepository hospedeRepository,SituacaoSocioeconomicaRepository situacaoSocioeconomicaRepository,
						   EstagioDoencaRepository estagioDoencaRepository, QuartoHospedagemRepository quartoHospedagemRepository, TipoRefeicaoRepository tipoRefeicaoRepository, FamiliarRepository familiarRepository, CursoRepository cursoRepository, EmprestimoRepository emprestimoRepository, MedicamentoRepository medicamentoRepository, AlimentoRepository alimentoRepository, MaterialRepository materialRepository, RoupaRepository roupaRepository, CabeloRepository cabeloRepository, TipoRecursoRepository tipoRecursoRepository) {
		return (args) -> {


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

			List<String> economicas = Arrays.asList("Classe Alta", "Classe Média", "Classe Média-Baixa", "Classe Baixa");

			for(String tipo : economicas) {
				SituacaoSocioeconomica socioeconomica = new SituacaoSocioeconomica();
				socioeconomica.setNome(tipo);
				situacaoSocioeconomicaRepository.save(socioeconomica);
			}


			List<String> estagios = Arrays.asList("Estágio 0", "Estágio 1", "Estágio 2", "Estágio 3", "Estágio 4");

			for(String tipo : estagios) {
				EstagioDoenca estagioDoenca = new EstagioDoenca();
				estagioDoenca.setNome(tipo);
				estagioDoencaRepository.save(estagioDoenca);
			}

			List<String> quartos = new ArrayList<>();
			for(int i = 0; i < 20; i++) {
				quartos.add(String.valueOf(i+1));
			}

			for(String tipo : quartos) {
				QuartoHospedagem quartoHospedagem = new QuartoHospedagem();
				quartoHospedagem.setNome(tipo);
				quartoHospedagemRepository.save(quartoHospedagem);
			}

			List<String> refeicoes = Arrays.asList("dieta normal", "geral", "dieta branda", "dieta pastosa", "dieta líquida-pastosa", "dieta líquida", "dieta líquida completa", "dieta líquida restrita");

			for(String tipo : refeicoes) {
				TipoRefeicao refeicao = new TipoRefeicao();
				refeicao.setNome(tipo);
				tipoRefeicaoRepository.save(refeicao);
			}

			TestUtils test = new TestUtils(familiarRepository,
					hospedeRepository,
					enderecoRepository,
					pacienteRepository,
					cursoRepository,
					situacaoSocioeconomicaRepository,
					estagioDoencaRepository,
					emprestimoRepository,
					quartoHospedagemRepository,
					tipoRefeicaoRepository,
                    medicamentoRepository, alimentoRepository, cabeloRepository, materialRepository, roupaRepository, tipoRecursoRepository);

			//test.generateRandomPaciente();
			//test.generateRandomPaciente();
			//test.generateRandomPaciente();

			//test.generateRandomHospede();
			//test.generateRandomHospede();
			//test.generateRandomHospede();

			//test.generateRandomFamiliar();
			//test.generateRandomFamiliar();
			//test.generateRandomFamiliar();

			//test.generateMedicamento();
			//test.generateRoupa();
		};
	}
}
