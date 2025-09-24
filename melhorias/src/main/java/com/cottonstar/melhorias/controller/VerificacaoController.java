package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.dto.VerificacaoDTO;
import com.cottonstar.melhorias.dto.VerificacaoUpdateDTO;
import com.cottonstar.melhorias.service.VerificacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/melhorias/{melhoriaId}/verificacao") // Endpoint aninhado
public class VerificacaoController {

    private final VerificacaoService verificacaoService;

    @PutMapping
    public ResponseEntity<VerificacaoDTO> atualizarVerificacao(
            @PathVariable Long melhoriaId,
            @Valid @RequestBody VerificacaoUpdateDTO verificacaoUpdateDTO) {

        VerificacaoDTO responseDTO = verificacaoService.atualizarVerificacao(melhoriaId, verificacaoUpdateDTO);

        return ResponseEntity.ok(responseDTO);
        }
}
