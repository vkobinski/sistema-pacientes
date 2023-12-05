package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Doacao;
import br.com.uepg.sistemapacientes.models.cRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

}
