package com.dnsouzadev.canesfacil.api.model.input;

import com.dnsouzadev.canesfacil.api.model.EnderecoModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EstabelecimentoInputModel {

    private String nome;
    private String descricao;
    private EnderecoModel endereco;
    private BigDecimal precoFrete;
    private String whatsapp;
    private Boolean delivery;
}
