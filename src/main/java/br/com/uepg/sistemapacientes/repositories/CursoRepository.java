package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<cCurso, Long> {
}
