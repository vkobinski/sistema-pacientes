package br.com.uepg.sistemapacientes.deserializer;

import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.models.cFamiliar;
import br.com.uepg.sistemapacientes.models.cPaciente;
import lombok.ToString;

@ToString
public class FamiliarWrapper {
        public cFamiliar familiar;
        public cEndereco endereco;
        public Long atendido;
}