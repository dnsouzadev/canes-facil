package com.dnsouzadev.canesfacil.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class EstabelecimentoModel {

    private UUID id;
    private String nome;
    private String descricao;
    private EnderecoModel endereco;
    private BigDecimal precoFrete;
    private String whatsapp;
    private Boolean delivery;


}
