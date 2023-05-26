package br.com.uepg.sistemapacientes.deserializer;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
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
public class EstagioDoencaDeserializer extends JsonDeserializer<EstagioDoenca> {


    private final EstagioDoencaRepository repository;

    @Autowired
    public EstagioDoencaDeserializer(EstagioDoencaRepository repository) {
        this.repository = repository;
    }


    @Override
    public EstagioDoenca deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String estagioString = p.getText();
        EstagioDoenca estagioDoenca = repository.findEstagioDoencaByNome(estagioString);

        if(estagioDoenca == null) {
            throw new JsonParseException(p, "Invalid EstagioDoenca: " + estagioString);
        }

        return estagioDoenca;
    }
}
