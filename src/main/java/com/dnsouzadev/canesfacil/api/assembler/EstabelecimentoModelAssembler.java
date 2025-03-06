package com.dnsouzadev.canesfacil.api.assembler;

import com.dnsouzadev.canesfacil.api.model.EstabelecimentoModel;
import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstabelecimentoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EstabelecimentoModel toModel(Estabelecimento estabelecimento) {
        return modelMapper.map(estabelecimento, EstabelecimentoModel.class);
    }

    public List<EstabelecimentoModel> toCollectionModel(List<Estabelecimento> estabelecimentos) {
        return estabelecimentos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
