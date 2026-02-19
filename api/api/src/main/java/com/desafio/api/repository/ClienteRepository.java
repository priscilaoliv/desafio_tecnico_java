package com.desafio.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM cliente WHERE (:nome IS NULL OR nome LIKE %:nome%) AND (:id IS NULL OR id = :id)")
    List<Cliente> buscarPorNomeOuId(@Param("nome") String nome, @Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM cliente WHERE email = :email LIMIT 1")
    Optional<Cliente> findByEmailNative(@Param("email") String email);
}