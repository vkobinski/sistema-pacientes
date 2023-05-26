package br.com.uepg.sistemapacientes.deserializer;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.repositories.QuartoHospedagemRepository;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class QuartoHospedagemDeserializer extends JsonDeserializer<QuartoHospedagem> {


    private final QuartoHospedagemRepository repository;

    @Autowired
    public QuartoHospedagemDeserializer(QuartoHospedagemRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuartoHospedagem deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String estagioString = p.getText();
        QuartoHospedagem quartoHospedagem = repository.getQuartoHospedagemByNome(estagioString);

        if(quartoHospedagem == null) {
            throw new JsonParseException(p, "Invalid QuartoHospedagem: " + estagioString);
        }

        return quartoHospedagem;
    }
}
