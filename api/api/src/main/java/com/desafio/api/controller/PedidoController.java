package com.desafio.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.api.model.Pedido;
import com.desafio.api.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> criar(@Valid @RequestBody Pedido pedido) {
        Pedido criado = service.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long clienteId) {
        List<Pedido> pedidos = service.listarPorCliente(clienteId);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/relatorio-totais")
    public ResponseEntity<List<Map<String, Object>>> obterRelatorio() {
        List<Map<String, Object>> relatorio = service.obterRelatorioSomaPorCliente();
        return ResponseEntity.ok(relatorio);
    }
}