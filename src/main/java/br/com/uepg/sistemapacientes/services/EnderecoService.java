package br.com.uepg.sistemapacientes.services;

import br.com.uepg.sistemapacientes.models.cAlimento;
import br.com.uepg.sistemapacientes.models.cEndereco;
import br.com.uepg.sistemapacientes.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    public List<cEndereco> getEnderecos() {
        return enderecoRepository.findAll();
    }

    public cEndereco createEndereco(cEndereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public cEndereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id).get();
    }


}
