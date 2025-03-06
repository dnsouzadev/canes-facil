package com.dnsouzadev.canesfacil.domain.service;

import com.dnsouzadev.canesfacil.domain.model.Estabelecimento;
import com.dnsouzadev.canesfacil.domain.repository.EstabelecimentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EstabelecimentoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public List<Estabelecimento> listar() {
        return estabelecimentoRepository.findAll();
    }

    @Transactional
    public Estabelecimento salvar(Estabelecimento estabelecimento) {
        return estabelecimentoRepository.save(estabelecimento);
    }

    @Transactional
    public void excluir(UUID estabelecimentoId) {
        estabelecimentoRepository.deleteById(estabelecimentoId);
    }


    public Estabelecimento buscarOuFalhar(UUID estabelecimentoId) {
        return estabelecimentoRepository.findById(estabelecimentoId)
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
    }
}
