package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.dto.AdicionarParticipantesDTO;
import com.cottonstar.melhorias.dto.ExecucaoDTO;
import com.cottonstar.melhorias.dto.ExecucaoUpdateDTO;
import com.cottonstar.melhorias.dto.ParticipacaoExecucaoDTO;
import com.cottonstar.melhorias.service.ExecucaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
