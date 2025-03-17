package com.dnsouzadev.canesfacil.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    @JsonIgnore
    private Estabelecimento estabelecimento;
}
