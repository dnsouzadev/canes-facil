package com.dnsouzadev.canesfacil.api.model.input;

import com.dnsouzadev.canesfacil.api.model.EnderecoModel;
import com.dnsouzadev.canesfacil.domain.model.Categorias;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EstabelecimentoInputModel {

    private String nome;
    private String descricao;
    private EnderecoModel endereco;
    private Categorias categoria;
    private BigDecimal precoFrete;
    private String whatsapp;
    private Boolean delivery;
}
