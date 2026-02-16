package com.desafio.api.repository;

import com.desafio.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM cliente WHERE nome LIKE %:nome% OR id = :id", nativeQuery = true)
    List<Cliente> buscarPorNomeOuId(@Param("nome") String nome, @Param("id") Long id);
}
