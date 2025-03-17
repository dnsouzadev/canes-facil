package com.dnsouzadev.canesfacil.api.controller;

import com.dnsouzadev.canesfacil.api.assembler.ProdutoInputModelDisassembler;
import com.dnsouzadev.canesfacil.api.assembler.ProdutoModelAssembler;
import com.dnsouzadev.canesfacil.api.model.ProdutoModel;
import com.dnsouzadev.canesfacil.api.model.input.ProdutoInputModel;
import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import com.dnsouzadev.canesfacil.domain.service.EstabelecimentoService;
import com.dnsouzadev.canesfacil.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoModelAssembler produtoModelAssembler;

    @Autowired
    private ProdutoInputModelDisassembler produtoInputModelDisassembler;

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @GetMapping
    public List<ProdutoModel> listar() {
        return produtoModelAssembler.toCollectionModel(produtoService.listar());
    }

    @GetMapping("/{produtoId}")
    public ProdutoModel buscarPorId(@PathVariable Long produtoId) {
        return produtoModelAssembler.toModel(produtoService.buscarOuFalhar(produtoId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object adicionar(@RequestBody ProdutoInputModel produtoInput) {
//        Estabelecimento estabelecimento = estabelecimentoService.buscarOuFalhar(produtoInput.getEstabelecimentoId());
//        return produtoModelAssembler.toModel(produtoService.salvar(produtoInputModelDisassembler.toDomainObject(produtoInput)));
        return produtoService.salvarProduto(produtoInput);

    }

    @PutMapping("/{produtoId}")
    public ProdutoModel atualizar(@PathVariable Long produtoId, @RequestBody ProdutoInputModel produtoInput) {
        var produtoAtual = produtoService.buscarOuFalhar(produtoId);
        produtoInputModelDisassembler.copyToDomainObject(produtoInput, produtoAtual);
        return produtoModelAssembler.toModel(produtoService.salvar(produtoAtual));
    }

    @DeleteMapping("/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long produtoId) {
        produtoService.excluir(produtoId);
    }


}
