package com.dnsouzadev.canesfacil.domain.repository;

import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import com.dnsouzadev.canesfacil.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    @Query("from Produto p where p.estabelecimento.id = :estabelecimentoId")
    List<Produto> findByEstabelecimentoId(Long estabelecimentoId);
}
