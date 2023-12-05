package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.Enums.TipoRecurso;
import br.com.uepg.sistemapacientes.models.cMedicamento;
import br.com.uepg.sistemapacientes.repositories.MedicamentoRepository;
import br.com.uepg.sistemapacientes.repositories.TipoRecursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    @Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<cMedicamento> getMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public cMedicamento createMedicamento(cMedicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public cMedicamento getById(Long id) {
        return medicamentoRepository.findById(id).get();
    }

    @Transactional
    public void addQtdInMedicamento(String nome, int quantidade) {
        List<cMedicamento> medicamentos = medicamentoRepository.getAllByNome(nome);
        for(cMedicamento medicamento : medicamentos) {
            int quantidadeNova = medicamento.getQuantidadeTotal() + quantidade;
            medicamento.setQuantidadeTotal(quantidadeNova);
        }
    }

}
