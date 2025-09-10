package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.ComentarioModel;
import com.cottonstar.melhorias.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioModel salvar(ComentarioModel comentarioModel) {
        return comentarioRepository.save(comentarioModel);
    }

    public List<ComentarioModel> listarTodos() {
        return comentarioRepository.findAll();
    }
}