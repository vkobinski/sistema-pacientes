package br.com.uepg.sistemapacientes.deserializer;

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
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@JsonComponent
public class SqlTimeDeserializer extends JsonDeserializer<Time> {


    @Override
    public Time deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String javaTime = p.getText();

        LocalTime localTime = LocalTime.parse(javaTime);
        Time time = Time.valueOf(localTime);

        return time;
    }
}
