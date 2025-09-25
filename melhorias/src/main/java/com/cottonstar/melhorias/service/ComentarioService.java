package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.ComentarioExecucao;
import com.cottonstar.melhorias.repository.ComentarioExecucaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioExecucaoRepository comentarioExecucaoRepository;

    public ComentarioExecucao criarComentario(ComentarioExecucao comentario) {
        return comentarioExecucaoRepository.save(comentario);
    }

    public Optional<ComentarioExecucao> buscarPorId(Long id) {
        return comentarioExecucaoRepository.findById(id);
    }

    public List<ComentarioExecucao> listarTodos() {
        return comentarioExecucaoRepository.findAll();
    }

    public void deletarComentario(Long id) {
        comentarioExecucaoRepository.deleteById(id);
    }
}