package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<cAlimento, Long> {
}