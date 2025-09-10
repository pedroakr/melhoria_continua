package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.VerificacaoModel;
import com.cottonstar.melhorias.repository.VerificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerificacaoService {

    private final VerificacaoRepository verificacaoRepository;

    public VerificacaoModel salvar(VerificacaoModel verificacaoModel) {
        return verificacaoRepository.save(verificacaoModel);
    }

    public Optional<VerificacaoModel> buscarPorId(String id) {
        return verificacaoRepository.findById(id);
    }
}
