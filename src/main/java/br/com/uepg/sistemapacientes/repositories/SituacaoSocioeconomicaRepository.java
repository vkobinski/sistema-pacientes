package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Enums.SituacaoSocioeconomica;
import br.com.uepg.sistemapacientes.models.cAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoSocioeconomicaRepository extends JpaRepository<SituacaoSocioeconomica, Long> {

    public SituacaoSocioeconomica findSituacaoSocioeconomicaByNome(String nome);
}