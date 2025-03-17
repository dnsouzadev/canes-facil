package com.dnsouzadev.canesfacil.api.model;

import com.dnsouzadev.canesfacil.domain.model.Categorias;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class EstabelecimentoModel {

    private Long id;
    private String nome;
    private String descricao;
    private Categorias categoria;
    private EnderecoModel endereco;
    private BigDecimal precoFrete;
    private String whatsapp;
    private Boolean delivery;


}
