package br.com.uepg.sistemapacientes.deserializer;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.repositories.AtendidoRepository;
import br.com.uepg.sistemapacientes.repositories.EstagioDoencaRepository;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class AtendidoDeserializer extends JsonDeserializer<cAtendido> {


    private final AtendidoRepository repository;

    @Autowired
    public AtendidoDeserializer(AtendidoRepository repository) {
        this.repository = repository;
    }


    @Override
    public cAtendido deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String estagioString = p.getText();
        cAtendido estagioDoenca = repository.getByNomeContaining(estagioString);

        if(estagioDoenca == null) {
            throw new JsonParseException(p, "Invalid cAtendido: " + estagioString);
        }

        return estagioDoenca;
    }
}
