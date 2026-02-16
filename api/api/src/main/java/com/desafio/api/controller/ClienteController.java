package com.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.api.model.Cliente;
import com.desafio.api.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return service.listarTodos();

    }

    @GetMapping("/busca")
    public List<Cliente> buscar(@RequestParam(required = false) String nome,
            @RequestParam(required = false) Long id) {
        return service.buscarPorNomeOuId(nome, id);
    }

}
