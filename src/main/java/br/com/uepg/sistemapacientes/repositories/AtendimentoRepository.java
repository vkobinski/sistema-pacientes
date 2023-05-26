package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cAtendimento;
import br.com.uepg.sistemapacientes.models.cHospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<cAtendimento, Long> {
}
