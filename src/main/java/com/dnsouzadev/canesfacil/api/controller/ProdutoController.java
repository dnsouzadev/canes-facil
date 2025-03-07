package com.dnsouzadev.canesfacil.api.controller;

import com.dnsouzadev.canesfacil.api.assembler.ProdutoInputModelDisassembler;
import com.dnsouzadev.canesfacil.api.assembler.ProdutoModelAssembler;
import com.dnsouzadev.canesfacil.api.model.ProdutoModel;
import com.dnsouzadev.canesfacil.api.model.input.ProdutoInputModel;
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

    @GetMapping
    public List<ProdutoModel> listar() {
        return produtoModelAssembler.toCollectionModel(produtoService.listar());
    }

    @GetMapping("/{produtoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel buscarPorId(@PathVariable UUID produtoId) {
        return produtoModelAssembler.toModel(produtoService.buscarOuFalhar(produtoId));
    }

    @PostMapping
    public ProdutoModel adicionar(@RequestBody ProdutoInputModel produtoInput) {
        return produtoModelAssembler.toModel(produtoService.salvar(produtoInputModelDisassembler.toDomainObject(produtoInput)));
    }

    @PutMapping("/{produtoId}")
    public ProdutoModel atualizar(@PathVariable UUID produtoId, @RequestBody ProdutoInputModel produtoInput) {
        var produtoAtual = produtoService.buscarOuFalhar(produtoId);
        produtoInputModelDisassembler.copyToDomainObject(produtoInput, produtoAtual);
        return produtoModelAssembler.toModel(produtoService.salvar(produtoAtual));
    }

    @DeleteMapping("/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID produtoId) {
        produtoService.excluir(produtoId);
    }


}
