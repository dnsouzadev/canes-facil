package com.dnsouzadev.canesfacil.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProdutoModel {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal preco;

}
