package com.desafio.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.api.model.Produto;

import jakarta.transaction.Transactional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "SELECT * FROM produto WHERE descricao LIKE %:desc% OR id = :id", nativeQuery = true)
    List<Produto> buscarPorDescricaoOuId(@Param("qtd") String desc, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE produto SET qtd_estoque = qtd_estoque - :qtd WHERE id = :id AND qtd_estoque >= :qtd", nativeQuery = true)
    int atualizarEstoque(@Param("id") Long id, @Param("qtd") Integer qtd);
}
