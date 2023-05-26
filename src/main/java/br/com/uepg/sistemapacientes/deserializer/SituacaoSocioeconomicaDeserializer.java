package br.com.uepg.sistemapacientes.deserializer;

import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import br.com.uepg.sistemapacientes.repositories.SituacaoSocioeconomicaRepository;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class SituacaoSocioeconomicaDeserializer extends JsonDeserializer<SituacaoSocioeconomica> {


    private final SituacaoSocioeconomicaRepository repository;

    @Autowired
    public SituacaoSocioeconomicaDeserializer(SituacaoSocioeconomicaRepository repository) {
        this.repository = repository;
    }

    @Override
    public SituacaoSocioeconomica deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String situacaoString = p.getText();
        SituacaoSocioeconomica situacaoSocioeconomica = repository.findSituacaoSocioeconomicaByNome(situacaoString);

        if(situacaoSocioeconomica == null) {
            throw new JsonParseException(p, "Invalid SituacaoSocioeconomica: " + situacaoString);
        }

        return situacaoSocioeconomica;
    }
}
