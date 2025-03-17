package com.dnsouzadev.canesfacil.api.controller;

import com.dnsouzadev.canesfacil.api.assembler.EstabelecimentoInputModelDisassembler;
import com.dnsouzadev.canesfacil.api.assembler.EstabelecimentoModelAssembler;
import com.dnsouzadev.canesfacil.api.model.EstabelecimentoModel;
import com.dnsouzadev.canesfacil.api.model.input.EstabelecimentoInputModel;
import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import com.dnsouzadev.canesfacil.domain.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @Autowired
    private EstabelecimentoModelAssembler estabelecimentoModelAssembler;

    @Autowired
    private EstabelecimentoInputModelDisassembler estabelecimentoInputModelDisassembler;

    @GetMapping
    public List<EstabelecimentoModel> listar() {
        return estabelecimentoModelAssembler.toCollectionModel(estabelecimentoService.listar());
    }

    @GetMapping("/{estabelecimentoId}")
    public EstabelecimentoModel buscar(@PathVariable Long estabelecimentoId) {
        return estabelecimentoModelAssembler.toModel(estabelecimentoService.buscarOuFalhar(estabelecimentoId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstabelecimentoModel adicionar(@RequestBody EstabelecimentoInputModel input) {
        Estabelecimento estabelecimento = estabelecimentoInputModelDisassembler.toDomain(input);
        return estabelecimentoModelAssembler.toModel(estabelecimentoService.salvar(estabelecimento));
    }

    @PutMapping("/{estabelecimentoId}")
    public EstabelecimentoModel atualizar(@PathVariable Long estabelecimentoId, @RequestBody EstabelecimentoInputModel input) {
        Estabelecimento estabelecimentoAtual = estabelecimentoService.buscarOuFalhar(estabelecimentoId);
        estabelecimentoInputModelDisassembler.copyToDomainObject(input, estabelecimentoAtual);
        return estabelecimentoModelAssembler.toModel(estabelecimentoService.salvar(estabelecimentoAtual));
    }

    @DeleteMapping("/{estabelecimentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long estabelecimentoId) {
        estabelecimentoService.excluir(estabelecimentoId);
    }

}
