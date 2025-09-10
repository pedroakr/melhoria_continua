package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.PlanoModel;
import com.cottonstar.melhorias.repository.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoModel salvar(PlanoModel planoModel) {
        return planoRepository.save(planoModel);
    }

    public Optional<PlanoModel> buscarPorId(String id) {
        return planoRepository.findById(id);
    }
}