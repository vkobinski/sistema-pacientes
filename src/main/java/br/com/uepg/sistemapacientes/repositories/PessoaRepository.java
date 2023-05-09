package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<cPessoa, Long> {
}
