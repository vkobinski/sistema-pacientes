package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Enums.EstagioDoenca;
import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstagioDoencaRepository extends JpaRepository<EstagioDoenca, Long> {

    public EstagioDoenca findEstagioDoencaByNome(String nome);
}