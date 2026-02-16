package com.desafio.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.api.model.Pedido;
import com.desafio.api.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return service.criarPedido(pedido);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> listarPorCliente(@PathVariable Long clienteId) {
        return service.listarPorCliente(clienteId);
    }

    @GetMapping("/relatorio-totais")
    public List<Map<String, Object>> obterRelatorio() {
        return service.obterRelatorioSomaPorCliente();
    }
}
