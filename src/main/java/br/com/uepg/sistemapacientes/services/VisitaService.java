package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cVisita;
import br.com.uepg.sistemapacientes.models.cVoluntaria;
import br.com.uepg.sistemapacientes.repositories.VisitaRepository;
import br.com.uepg.sistemapacientes.repositories.VoluntariaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VisitaService {

    private final VisitaRepository visitaRepository;
    private final VoluntariaRepository voluntariaRepository;

    @Autowired
    public VisitaService(VisitaRepository visitaRepository, VoluntariaRepository voluntariaRepository) {
        this.visitaRepository = visitaRepository;
        this.voluntariaRepository = voluntariaRepository;
    }

    public List<cVisita> getVisitas() {
        return visitaRepository.findAll();
    }

    public cVisita criaVisita(cVisita visita) {
        return visitaRepository.save(visita);
    }

    public cVisita setVisitaOcorrida(Long idVisita, String descricaoVisita) {
        Optional<cVisita> byId = visitaRepository.findById(idVisita);

        if(byId.isPresent()) {
            cVisita visita = byId.get();
            visita.setDescricaoVisita(descricaoVisita);

            return visitaRepository.save(visita);

        }

        return null;
    }

    @Transactional
    public cVisita atualizaVisita(Long idVisita, Date dataVisita, List<Long> idVoluntarias) {
        Optional<cVisita> visitaOptional = visitaRepository.findById(idVisita);
        if (visitaOptional.isEmpty()) {
            log.error("Visita não encontrada com ID: " + idVisita);
            return null;
        }

        if(dataVisita != null) {
            visitaOptional.get().setData_visita(dataVisita);
        }

        if(idVoluntarias != null) {
            visitaOptional.get().setVoluntarias(new HashSet<>());
            idVoluntarias.forEach((voluntaria -> {
                Optional<cVoluntaria> voluntariaOp = voluntariaRepository.findById(voluntaria);
                voluntariaOp.ifPresent(cVoluntaria -> visitaOptional.get().getVoluntarias().add(cVoluntaria));
            }));
        }

        return visitaOptional.get();
    }

    public boolean deletaVisita(Long idVisita) {
        Optional<cVoluntaria> voluntariaOp = voluntariaRepository.findById(idVisita);
        if(voluntariaOp.isPresent()) {
            log.info("Excluindo Visita de ID: " + idVisita);
            voluntariaRepository.deleteById(voluntariaOp.get().getId_voluntaria());
            return true;
        }

        log.error("Não foi possível encontrar Visita de ID: " + idVisita);
        return false;
    }
}
