package com.dnsouzadev.canesfacil.domain.repository;

import com.dnsouzadev.canesfacil.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<UUID, Produto> {
}
