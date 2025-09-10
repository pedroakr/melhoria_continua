package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.ExecucaoModel;
import com.cottonstar.melhorias.repository.ExecucaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExecucaoService {

    private final ExecucaoRepository execucaoRepository;

    public ExecucaoModel salvar(ExecucaoModel execucaoModel) {
        return execucaoRepository.save(execucaoModel);
    }

    public Optional<ExecucaoModel> buscarPorId(String id) {
        return execucaoRepository.findById(id);
    }
}