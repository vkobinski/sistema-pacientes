package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.cMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<cMedicamento, Long> {
    public List<cMedicamento> getAllByNome(String nome);
}