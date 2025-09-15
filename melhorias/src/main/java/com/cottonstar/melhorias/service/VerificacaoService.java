package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Verificacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerificacaoService {

    private final VerificacaoRepository verificacaoRepository;

    public Verificacao salvar(Verificacao verificacao) {
        return verificacaoRepository.save(verificacao);
    }

    public Optional<Verificacao> buscarPorId(String id) {
        return verificacaoRepository.findById(id);
    }
}
