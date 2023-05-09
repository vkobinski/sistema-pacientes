package br.com.uepg.sistemapacientes.repositories;

import br.com.uepg.sistemapacientes.models.Enums.TipoMaterial;
import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMaterialRepository extends JpaRepository<TipoMaterial, Long> {

    public TipoMaterial getTipoMaterialByNome(String nome);
}
