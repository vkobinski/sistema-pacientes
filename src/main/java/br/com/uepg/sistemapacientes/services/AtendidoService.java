package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cAtendido;
import br.com.uepg.sistemapacientes.models.cPaciente;
import br.com.uepg.sistemapacientes.repositories.AtendidoRepository;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AtendidoService {

    private final AtendidoRepository atendidoRepository;

    @Autowired
    public AtendidoService(AtendidoRepository atendidoRepository) {
        this.atendidoRepository = atendidoRepository;
    }


    public List<cAtendido> getAtendidos() {
        return atendidoRepository.findAll();
    }

    public cAtendido findAtendidoById(Long id) {
        Optional<cAtendido> byId = atendidoRepository.findById(id);

        return byId.get();
    }

    public cAtendido findAtendidoByNome(String nome) {
        Optional<cAtendido> atendidoOp = atendidoRepository.findByNomeLikeIgnoreCase(nome);

        if(atendidoOp.isPresent()) return atendidoOp.get();

        throw new EntityNotFoundException("cAtendido não encontrado com nome: " + nome);
    }

    public cAtendido findAtendidoByCpf(String cpf) {
        Optional<cAtendido> byCpf = atendidoRepository.findByCpf(cpf);
        if(byCpf.isPresent()) return byCpf.get();

        throw new EntityNotFoundException("cAtendido não encontrado com CPF: " + cpf);
    }

    public cAtendido findAtendidoByRg(String rg) {
        Optional<cAtendido> byRg = atendidoRepository.findByRg(rg);
        if(byRg.isPresent()) return byRg.get();

        throw new EntityNotFoundException("cAtendido não encontrado com RG: " + rg);
    }
}
