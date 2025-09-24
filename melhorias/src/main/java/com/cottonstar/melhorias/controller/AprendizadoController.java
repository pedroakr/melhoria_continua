package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.dto.AprendizadoDTO;
import com.cottonstar.melhorias.dto.AprendizadoUpdateDTO;
import com.cottonstar.melhorias.dto.VerificacaoDTO;
import com.cottonstar.melhorias.dto.VerificacaoUpdateDTO;
import com.cottonstar.melhorias.service.AprendizadoService;
import com.cottonstar.melhorias.service.VerificacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/melhorias/{melhoriaId}/aprendizado") // Endpoint aninhado
public class AprendizadoController {

    private final AprendizadoService aprendizadoService;

    @PutMapping
    public ResponseEntity<AprendizadoDTO> atualizarAprendizado(
            @PathVariable Long melhoriaId,
            @Valid @RequestBody AprendizadoUpdateDTO aprendizadoUpdateDTO) {

        AprendizadoDTO responseDTO = aprendizadoService.atualizarAprendizado(melhoriaId, aprendizadoUpdateDTO);

        return ResponseEntity.ok(responseDTO);
    }
}
