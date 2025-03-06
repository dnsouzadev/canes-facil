package com.dnsouzadev.canesfacil.api.assembler;

import com.dnsouzadev.canesfacil.api.model.input.EstabelecimentoInputModel;
import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstabelecimentoInputModelDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Estabelecimento toDomain(EstabelecimentoInputModel estabelecimentoInputModel) {
        return modelMapper.map(estabelecimentoInputModel, Estabelecimento.class);
    }

    public void copyToDomainObject(EstabelecimentoInputModel estabelecimentoInputModel, Estabelecimento estabelecimento) {
        modelMapper.map(estabelecimentoInputModel, estabelecimento);
    }

}
