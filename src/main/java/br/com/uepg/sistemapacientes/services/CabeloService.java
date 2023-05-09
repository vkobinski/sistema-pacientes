package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cCabelo;
import br.com.uepg.sistemapacientes.models.cMedicamento;
import br.com.uepg.sistemapacientes.repositories.CabeloRepository;
import br.com.uepg.sistemapacientes.repositories.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabeloService {

    private final CabeloRepository cabeloRepository;

    @Autowired
    public CabeloService(CabeloRepository cabeloRepository) {
        this.cabeloRepository = cabeloRepository;
    }

    public List<cCabelo> getCabelos() {
        return cabeloRepository.findAll();
    }

    public cCabelo createCabelo(cCabelo cCabelo) {
        return cabeloRepository.save(cCabelo);
    }


}
