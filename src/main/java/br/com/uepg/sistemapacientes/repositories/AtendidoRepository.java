package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.models.cPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtendidoRepository extends JpaRepository<cAtendido, Long> {
    Optional<cAtendido> findByRg(String rg);
    Optional<cAtendido> findByCpf(String cpf);
    Optional<cAtendido> findByNomeLikeIgnoreCase(String nome);

}
