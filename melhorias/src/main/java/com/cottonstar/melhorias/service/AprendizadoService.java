package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Aprendizado;
import com.cottonstar.melhorias.repository.AprendizadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AprendizadoService {

    private final AprendizadoRepository aprendizadoRepository;

    public Aprendizado salvar(Aprendizado aprendizado) {
        return aprendizadoRepository.save(aprendizado);
    }

    public Optional<Aprendizado> buscarPorId(String id) {
        return aprendizadoRepository.findById(id);
    }
}