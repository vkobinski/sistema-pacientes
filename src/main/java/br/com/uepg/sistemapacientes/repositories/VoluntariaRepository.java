package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cVoluntaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntariaRepository extends JpaRepository<cVoluntaria, Long> {
}
