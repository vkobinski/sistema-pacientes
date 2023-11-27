package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Enums.QuartoHospedagem;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.Enums.TipoRefeicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRefeicaoRepository extends JpaRepository<TipoRefeicao, Long> {

    public TipoRefeicao getTipoRefeicaoByNome(String nome);

    public TipoRefeicao getTipoRefeicaoByNomeContaining(String nome);
}
