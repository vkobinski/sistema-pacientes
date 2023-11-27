package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoHospedagemRepository extends JpaRepository<QuartoHospedagem, Long> {

    public QuartoHospedagem getQuartoHospedagemByNome(String nome);
    public QuartoHospedagem getQuartoHospedagemByNomeContaining(String nome);
}
