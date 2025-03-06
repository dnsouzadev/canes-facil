package com.dnsouzadev.canesfacil.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {

    @Column(name = "endereco_bairro")
    private String bairro;
    @Column(name = "endereco_rua")
    private String rua;
    @Column(name = "endereco_numero")
    private String numero;
    @Column(name = "endereco_complemento")
    private String complemento;

}
