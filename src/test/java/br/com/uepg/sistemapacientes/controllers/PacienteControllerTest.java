package br.com.uepg.sistemapacientes.controllers;

import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import br.com.uepg.sistemapacientes.repositories.PacienteRepository;
import br.com.uepg.sistemapacientes.services.EnderecoService;
import br.com.uepg.sistemapacientes.services.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PacienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

    private cPaciente paciente;

    @BeforeEach
    public void setup() {

        cEndereco endereco = new cEndereco();
        endereco.setComplemento("Fundos");
        endereco.setNomeCidade("Ponta Grossa");
        endereco.setNomeEstado("Parana");
        endereco.setLogradouro("Rua Leila");
        endereco.setCep("12423212");
        endereco.setBairro("Nova Russia");
        endereco.setPontoReferencia("Escola");

        paciente = new cPaciente();
        paciente.setNome("John Doe");
        paciente.setCpf("13745578970");
        paciente.setRg("1482187678");
        paciente.setDataNascimento(Date.valueOf(LocalDate.now()));
        paciente.setEstadoCivil("Solteiro");
        paciente.setEndereco(endereco);
        paciente.setSexo('M');
        paciente.setProfissao("Programador");
        paciente.setRedesSociais(false);

    }


    @DisplayName("JUnit test for criaPaciente method")
    @Test
    void saveValidPaciente_ThenReturnPacienteObject() throws Exception {

        cPaciente savedPaciente = pacienteService.criaPaciente(paciente);
        System.out.println(savedPaciente);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/paciente")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                        .andExpect(jsonPath("$[1].nome", is("John Doe")));

    }

    @DisplayName("JUnit test for findPacienteByCpf method")
    @Test
    void findPacienteByCpf() {

        cPaciente savedPaciente = pacienteService.criaPaciente(paciente);

        System.out.println(savedPaciente);

        assertThat(savedPaciente.getCpf()).isEqualTo(paciente.getCpf());
    }
}