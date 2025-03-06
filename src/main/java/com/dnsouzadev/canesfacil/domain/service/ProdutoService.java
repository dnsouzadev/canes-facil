package com.dnsouzadev.canesfacil.domain.service;

import com.dnsouzadev.canesfacil.domain.model.Produto;
import com.dnsouzadev.canesfacil.domain.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(UUID produtoId, Produto produto) {
        Produto produtoAtual = buscarOuFalhar(produtoId);

        produto.setId(produtoAtual.getId());

        modelMapper.map(produto, produtoAtual);

        return produtoRepository.save(produto);
    }

    public void excluir(UUID produtoId) {
        produtoRepository.deleteById(produtoId);
    }

    public Produto buscarOuFalhar(UUID produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


}
