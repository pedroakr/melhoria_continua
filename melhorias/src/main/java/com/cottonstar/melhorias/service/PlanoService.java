package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Plano;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final PlanoRepository planoRepository;

    public Plano salvar(Plano plano) {
        return planoRepository.save(plano);
    }

    public Optional<Plano> buscarPorId(String id) {
        return planoRepository.findById(id);
    }
}