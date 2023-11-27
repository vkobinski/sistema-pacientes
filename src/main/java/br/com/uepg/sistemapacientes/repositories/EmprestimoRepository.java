package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<cEmprestimo, Long> {
}
