package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Execucao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExecucaoService {

    private final ExecucaoRepository execucaoRepository;

    public Execucao salvar(Execucao execucaoModel) {
        return execucaoRepository.save(execucaoModel);
    }

    public Optional<Execucao> buscarPorId(String id) {
        return execucaoRepository.findById(id);
    }
}