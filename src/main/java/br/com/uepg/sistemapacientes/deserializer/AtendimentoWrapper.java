package br.com.uepg.sistemapacientes.deserializer;

import br.com.uepg.sistemapacientes.models.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Getter
@Setter
public class AtendimentoWrapper {
        private Long profissional;
        private Long atendido;
        private Timestamp data;
}