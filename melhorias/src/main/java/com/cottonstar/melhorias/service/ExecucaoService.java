package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Execucao;
import com.cottonstar.melhorias.repository.ExecucaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExecucaoService {

    private final ExecucaoRepository execucaoRepository;

    public Execucao salvar(Execucao execucao) {
        return execucaoRepository.save(execucao);
    }

    public Optional<Execucao> buscarPorId(String id) {
        return execucaoRepository.findById(id);
    }
}