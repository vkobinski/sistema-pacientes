package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.models.cMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<cMaterial, Long> {
}
