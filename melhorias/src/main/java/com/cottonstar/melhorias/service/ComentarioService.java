package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Comentario;
import com.cottonstar.melhorias.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public Comentario criarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Optional<Comentario> buscarPorId(Integer id) {
        return comentarioRepository.findById(id);
    }

    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }

    public void deletarComentario(Integer id) {
        comentarioRepository.deleteById(id);
    }
}