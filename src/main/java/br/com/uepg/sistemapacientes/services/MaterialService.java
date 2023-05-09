package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.models.cMaterial;
import br.com.uepg.sistemapacientes.repositories.CabeloRepository;
import br.com.uepg.sistemapacientes.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<cMaterial> getMateriais() {
        return materialRepository.findAll();
    }

    public cMaterial createMaterial(cMaterial material) {
        return materialRepository.save(material);
    }

}
