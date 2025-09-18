package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.model.Comentario;
import com.cottonstar.melhorias.service.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody Comentario comentario) {
        Comentario novoComentario = comentarioService.criarComentario(comentario);
        return new ResponseEntity<>(novoComentario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {
        comentarioService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}