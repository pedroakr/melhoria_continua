package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Comentario;
import com.cottonstar.melhorias.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public Comentario salvar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }
}