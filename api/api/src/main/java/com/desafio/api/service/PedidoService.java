package com.desafio.api.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Import novo
import org.springframework.transaction.annotation.Transactional;

import com.desafio.api.model.Cliente;
import com.desafio.api.model.ItemPedido;
import com.desafio.api.model.Pedido;
import com.desafio.api.model.Produto;
import com.desafio.api.repository.ClienteRepository;
import com.desafio.api.repository.PedidoRepository;
import com.desafio.api.repository.ProdutoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        BigDecimal valorTotalPedido = BigDecimal.ZERO;

        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + pedido.getCliente().getId()));
        pedido.setCliente(cliente);

        for (ItemPedido item : pedido.getItens()) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + item.getProduto().getId()));

            item.setProduto(produto);

            int linhasAfetadas = produtoRepository.atualizarEstoque(produto.getId(), item.getQuantidade());

            if (linhasAfetadas == 0) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getDescricao());
            }

            item.setPedido(pedido);
            item.setValorUnitario(produto.getValor());

            if (item.getDesconto() == null) {
                item.setDesconto(BigDecimal.ZERO);
            }

            BigDecimal valorItem = produto.getValor()
                    .multiply(new BigDecimal(item.getQuantidade()))
                    .subtract(item.getDesconto());

            valorTotalPedido = valorTotalPedido.add(valorItem);
        }

        pedido.setValorTotal(valorTotalPedido);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPorCliente(Long clienteId) {
        return pedidoRepository.listarPedidosPorCliente(clienteId);
    }

    public List<Map<String, Object>> obterRelatorioSomaPorCliente() {
        return pedidoRepository.consultarValorTotalPorCliente();
    }
}