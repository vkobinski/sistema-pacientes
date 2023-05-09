package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Enums.TipoAlimento;
import br.com.uepg.sistemapacientes.models.Enums.TipoCabelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAlimentoRepository extends JpaRepository<TipoAlimento, Long> {
    TipoAlimento getTipoAlimentoByNome(String nome);
}
