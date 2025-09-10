package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.AprendizadoModel;
import com.cottonstar.melhorias.repository.AprendizadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AprendizadoService {

    private final AprendizadoRepository aprendizadoRepository;

    public AprendizadoModel salvar(AprendizadoModel aprendizadoModel) {
        return aprendizadoRepository.save(aprendizadoModel);
    }

    public Optional<AprendizadoModel> buscarPorId(String id) {
        return aprendizadoRepository.findById(id);
    }
}