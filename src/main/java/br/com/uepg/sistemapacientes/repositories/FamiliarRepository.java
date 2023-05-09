package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliarRepository extends JpaRepository<cFamiliar, Long> {


}
