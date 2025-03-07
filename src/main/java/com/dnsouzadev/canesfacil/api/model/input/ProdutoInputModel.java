package com.dnsouzadev.canesfacil.api.model.input;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProdutoInputModel {

    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal preco;
    private UUID estabelecimentoId;

}
