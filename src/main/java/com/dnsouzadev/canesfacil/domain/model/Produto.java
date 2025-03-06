package com.dnsouzadev.canesfacil.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;
    private String descricao;
    private String imagem;
    private double preco;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;
}
