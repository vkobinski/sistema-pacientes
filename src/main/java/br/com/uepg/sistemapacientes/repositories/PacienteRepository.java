package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.models.cVoluntaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<cPaciente, Long> {

    Optional<cPaciente> findByCpf(String cpf);

    Optional<cPaciente> findByNomeLikeIgnoreCase(String nome);
}
