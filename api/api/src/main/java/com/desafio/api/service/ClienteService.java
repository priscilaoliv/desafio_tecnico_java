package com.desafio.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.api.model.Cliente;
import com.desafio.api.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        Optional<Cliente> clienteExistente = repository.findByEmailNative(cliente.getEmail());

        if (clienteExistente.isPresent()) {
            throw new RuntimeException("Erro: O e-mail " + cliente.getEmail() + " já está cadastrado no sistema.");
        }

        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public List<Cliente> buscarPorNomeOuId(String nome, Long id) {
        return repository.buscarPorNomeOuId(nome, id);
    }
}