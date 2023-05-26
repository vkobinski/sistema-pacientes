package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Enums.Especialidade;
import br.com.uepg.sistemapacientes.models.cAlimento;
import br.com.uepg.sistemapacientes.models.cProfissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<cProfissional, Long> {

    Optional<cProfissional> findByNomeLikeIgnoreCase(String nome);

    List<cProfissional> findAllByEspecialidade(Especialidade especialidade);
}