package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cVisita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<cVisita, Long> {
}
