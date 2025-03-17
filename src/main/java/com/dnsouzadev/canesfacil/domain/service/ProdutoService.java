package com.dnsouzadev.canesfacil.domain.service;

import com.dnsouzadev.canesfacil.api.model.input.ProdutoInputModel;
import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import com.dnsouzadev.canesfacil.domain.model.Produto;
import com.dnsouzadev.canesfacil.domain.repository.EstabelecimentoRepository;
import com.dnsouzadev.canesfacil.domain.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto salvarProduto(ProdutoInputModel produtoInput) {
        Estabelecimento estabelecimento = estabelecimentoRepository.findById(produtoInput.getEstabelecimentoId())
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

        Produto produto = new Produto();
        produto.setNome(produtoInput.getNome());
        produto.setDescricao(produtoInput.getDescricao());
        produto.setImagem(produtoInput.getImagem());
        produto.setPreco(produtoInput.getPreco());
        produto.setEstabelecimento(estabelecimento);

        return produtoRepository.save(produto);
    }

    @Transactional
    public void excluir(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }

    public Produto buscarOuFalhar(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


}
