package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cFamiliar;
import br.com.uepg.sistemapacientes.models.cPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamiliarRepository extends JpaRepository<cFamiliar, Long> {

    Optional<cFamiliar> findByCpf(String cpf);

    Optional<cFamiliar> findByNomeLikeIgnoreCase(String nome);
}
