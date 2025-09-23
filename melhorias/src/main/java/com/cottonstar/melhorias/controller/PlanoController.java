package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.dto.PlanoDTO; // Reutilize o PlanoDTO para a resposta
import com.cottonstar.melhorias.dto.PlanoUpdateDTO;
import com.cottonstar.melhorias.model.Plano;
import com.cottonstar.melhorias.service.PlanoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/melhorias/{melhoriaId}/plano") // Endpoint aninhado
public class PlanoController {

    private final PlanoService planoService;

    @PutMapping
    public ResponseEntity<PlanoDTO> atualizarPlano(
            @PathVariable Long melhoriaId,
            @Valid @RequestBody PlanoUpdateDTO planoUpdateDTO) {

        PlanoDTO responseDTO = planoService.atualizarPlano(melhoriaId, planoUpdateDTO);

        return ResponseEntity.ok(responseDTO);
    }
}