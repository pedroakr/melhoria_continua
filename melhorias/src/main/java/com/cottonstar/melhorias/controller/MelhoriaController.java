package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.dto.CriarMelhoriaDTO;
import com.cottonstar.melhorias.dto.MelhoriaDTO; // Importe o DTO
import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.service.MelhoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/melhorias")
public class MelhoriaController {

    private final MelhoriaService melhoriaService;

    // --- NOVO ENDPOINT PARA A PÁGINA INICIAL ---
    @GetMapping("/minhas-melhorias")
    public ResponseEntity<List<MelhoriaDTO>> listarMinhasMelhorias(Authentication authentication) {
        // 1. Pega o e-mail do usuário a partir do token de autenticação
        String emailUsuarioLogado = authentication.getName();

        // 2. Chama o serviço para buscar e converter os dados
        List<MelhoriaDTO> minhasMelhorias = melhoriaService.listarMelhoriasPorUsuario(emailUsuarioLogado);

        // 3. Retorna a lista de DTOs com status 200 OK
        return ResponseEntity.ok(minhasMelhorias);
    }

    @PostMapping("/criar")
    public ResponseEntity<MelhoriaDTO> criarMelhoria(@RequestBody CriarMelhoriaDTO criarMelhoriaDTO, Authentication authentication) {
        String emailUsuarioLogado = authentication.getName();
        Melhoria novaMelhoria = melhoriaService.criarMelhoria(criarMelhoriaDTO, emailUsuarioLogado);

        // Converte a entidade criada para DTO antes de retornar
        return new ResponseEntity<>(new MelhoriaDTO(novaMelhoria), HttpStatus.CREATED);
    }

}