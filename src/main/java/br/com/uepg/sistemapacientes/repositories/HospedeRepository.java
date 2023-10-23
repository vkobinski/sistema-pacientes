package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cHospede;
import br.com.uepg.sistemapacientes.models.cPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospedeRepository extends JpaRepository<cHospede, Long> {

    Optional<cHospede> findByCpf(String cpf);

    Optional<cHospede> findByNomeLikeIgnoreCase(String nome);
}
