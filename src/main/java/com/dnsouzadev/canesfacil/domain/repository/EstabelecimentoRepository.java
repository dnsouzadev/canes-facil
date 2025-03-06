package com.dnsouzadev.canesfacil.domain.repository;

import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstabelecimentoRepository extends JpaRepository<UUID, Estabelecimento> {
}
