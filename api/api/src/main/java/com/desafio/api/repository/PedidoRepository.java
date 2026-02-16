package com.desafio.api.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.desafio.api.model.Pedido;
import java.util.Map;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM pedido WHERE cliente_id = :clienteId", nativeQuery = true)
    List<Pedido> listarPedidosPorCliente(@Param("clienteId") Long clienteId);

    @Query(value = "SELECT DISTINCT p.* FROM pedido p " +
            "JOIN item_pedido ip ON p.id = ip.pedido_id " +
            "WHERE ip.produto_id = :produtoId", nativeQuery = true)
    List<Pedido> listarPedidosQueContemProduto(@Param("produtoId") Long produtoId);

    @Query(value = "SELECT * FROM pedido WHERE id = :id OR data_pedido BETWEEN :inicio AND :fim", nativeQuery = true)
    List<Pedido> consultarPorIdOuPeriodo(@Param("id") Long id, @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim);

    @Query(value = "SELECT c.nome, SUM(p.valor_total) as valor_total_pedidos " +
            "FROM cliente c " +
            "JOIN pedido p ON c.id = p.cliente_id " +
            "GROUP BY c.nome", nativeQuery = true)
    List<Map<String, Object>> consultarValorTotalPorCliente();

}
