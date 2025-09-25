package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.dto.*;
import com.cottonstar.melhorias.service.ExecucaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/melhorias/{melhoriaId}/execucao")
public class ExecucaoController {

    private final ExecucaoService execucaoService;

    @PutMapping
    public ResponseEntity<ExecucaoDTO> atualizarExecucao(
            @PathVariable Long melhoriaId,
            @Valid @RequestBody ExecucaoUpdateDTO execucaoUpdateDTO) {

        ExecucaoDTO responseDTO = execucaoService.atualizarExecucao(melhoriaId, execucaoUpdateDTO);

        return ResponseEntity.ok(responseDTO);
    }

    // --- ENDPOINT PARA ADICIONAR PARTICIPANTES ---
    @PostMapping("/participantes")
    public ResponseEntity<List<ParticipacaoExecucaoDTO>> adicionarParticipantes(
            @PathVariable Long melhoriaId,
            @Valid @RequestBody AdicionarParticipantesDTO dto) {

        List<ParticipacaoExecucaoDTO> novasParticipacoes = execucaoService.adicionarParticipantes(melhoriaId, dto);
        return new ResponseEntity<>(novasParticipacoes, HttpStatus.CREATED);
    }

    // --- ENDPOINT PARA CRIAR UM NOVO COMENTÁRIO ---
    @PostMapping("/comentarios")
    public ResponseEntity<ComentarioDTO> adicionarComentario(
            @PathVariable Long melhoriaId,
            @Valid @RequestBody ComentarioCreateDTO comentarioDTO,
            Authentication authentication) {
        String emailUsuarioLogado = authentication.getName();
        ComentarioDTO novoComentario = execucaoService.adicionarComentario(melhoriaId, comentarioDTO, emailUsuarioLogado);
        return new ResponseEntity<>(novoComentario, HttpStatus.CREATED);
    }

    // --- ENDPOINT PARA ATUALIZAR UM COMENTÁRIO EXISTENTE ---
    // Note que {comentarioId} não depende de {melhoriaId}, mas manter a rota aninhada é bom para consistência.
    @PutMapping("/comentarios/{comentarioId}")
    public ResponseEntity<ComentarioDTO> atualizarComentario(
            @PathVariable Long melhoriaId, // pode ser usado para validação extra se necessário
            @PathVariable Long comentarioId,
            @Valid @RequestBody ComentarioUpdateDTO comentarioDTO,
            Authentication authentication) throws AccessDeniedException {
        String emailUsuarioLogado = authentication.getName();
        ComentarioDTO comentarioAtualizado = execucaoService.atualizarComentario(comentarioId, comentarioDTO, emailUsuarioLogado);
        return ResponseEntity.ok(comentarioAtualizado);
    }
}
