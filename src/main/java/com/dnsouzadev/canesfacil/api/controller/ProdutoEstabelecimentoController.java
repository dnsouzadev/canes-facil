package com.dnsouzadev.canesfacil.api.controller;

import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import com.dnsouzadev.canesfacil.domain.model.Produto;
import com.dnsouzadev.canesfacil.domain.repository.EstabelecimentoRepository;
import com.dnsouzadev.canesfacil.domain.repository.ProdutoRepository;
import com.dnsouzadev.canesfacil.domain.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/estabelecimentos/{estabelecimentoId}/produtos")
public class ProdutoEstabelecimentoController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar(@PathVariable UUID estabelecimentoId) {
        return estabelecimentoService.listarProdutos(estabelecimentoId);
    }

    // Adicionar um produto a um estabelecimento
    @PutMapping("{produtoId}")
    public ResponseEntity<String> associarProduto(
            @PathVariable UUID estabelecimentoId,
            @PathVariable UUID produtoId
    ) {
        Optional<Estabelecimento> estabelecimentoOpt = estabelecimentoRepository.findById(estabelecimentoId);
        Optional<Produto> produtoOpt = produtoRepository.findById(produtoId);

        if (estabelecimentoOpt.isEmpty() || produtoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimento estabelecimento = estabelecimentoOpt.get();
        Produto produto = produtoOpt.get();

        estabelecimento.adicionarProduto(produto);
        estabelecimentoRepository.save(estabelecimento);

        return ResponseEntity.ok("Produto associado com sucesso!");
    }

    // Remover um produto de um estabelecimento
    @DeleteMapping("/{produtoId}")
    public ResponseEntity<String> desassociarProduto(
            @PathVariable UUID estabelecimentoId,
            @PathVariable UUID produtoId
    ) {
        Optional<Estabelecimento> estabelecimentoOpt = estabelecimentoRepository.findById(estabelecimentoId);
        Optional<Produto> produtoOpt = produtoRepository.findById(produtoId);

        if (estabelecimentoOpt.isEmpty() || produtoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Estabelecimento estabelecimento = estabelecimentoOpt.get();
        Produto produto = produtoOpt.get();

        estabelecimento.removerProduto(produto);
        estabelecimentoRepository.save(estabelecimento);

        return ResponseEntity.ok("Produto desassociado com sucesso!");
    }
}

