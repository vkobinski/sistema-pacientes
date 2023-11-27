package br.com.uepg.sistemapacientes.deserializer;

import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import br.com.uepg.sistemapacientes.repositories.TipoRefeicaoRepository;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class TipoRefeicaoDeserializer extends JsonDeserializer<TipoRefeicao> {


    private final TipoRefeicaoRepository repository;

    public TipoRefeicaoDeserializer(TipoRefeicaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoRefeicao deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String estagioString = p.getText();
        TipoRefeicao tipoRefeicao = repository.getTipoRefeicaoByNomeContaining(estagioString);

        if(tipoRefeicao == null) {
            throw new JsonParseException(p, "Invalid TipoRefeicao: " + estagioString);
        }

        return tipoRefeicao;
    }
}
