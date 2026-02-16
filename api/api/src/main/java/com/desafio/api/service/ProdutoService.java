package com.desafio.api.service;

import com.desafio.api.model.Produto;
import com.desafio.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public List<Produto> buscarPorDescricaoOuId(String descricao, Long id) {
        return repository.buscarPorDescricaoOuId(descricao, id);
    }
}