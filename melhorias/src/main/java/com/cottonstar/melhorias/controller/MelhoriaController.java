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

    @PostMapping("/criar")
    public ResponseEntity<MelhoriaDTO> criarMelhoria(@RequestBody CriarMelhoriaDTO criarMelhoriaDTO, Authentication authentication) {
        String emailUsuarioLogado = authentication.getName();
        Melhoria novaMelhoria = melhoriaService.criarMelhoria(criarMelhoriaDTO, emailUsuarioLogado);

        // Converte a entidade criada para DTO antes de retornar
        return new ResponseEntity<>(new MelhoriaDTO(novaMelhoria), HttpStatus.CREATED);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<MelhoriaDTO> atualizarMelhoria(@PathVariable Long id, @RequestBody Melhoria melhoriaAtualizada) {
        // ATENÇÃO: Receber a entidade completa no PUT também é uma má prática.
        // O ideal seria criar um MelhoriaUpdateDTO.
        return melhoriaService.buscarPorId(id)
                .map(melhoriaExistente -> {
                    melhoriaAtualizada.setId(id);
                    Melhoria melhoriaSalva = melhoriaService.atualizarMelhoria(melhoriaAtualizada);
                    return ResponseEntity.ok(new MelhoriaDTO(melhoriaSalva)); // Converte para DTO
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MelhoriaDTO>> listarMelhorias() {
        List<Melhoria> melhorias = melhoriaService.listarTodas();

        // Converte a lista de entidades para uma lista de DTOs
        List<MelhoriaDTO> melhoriasDTO = melhorias.stream()
                .map(MelhoriaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(melhoriasDTO);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<MelhoriaDTO> buscarMelhoriaPorId(@PathVariable Long id) {
        return melhoriaService.buscarPorId(id)
                .map(melhoria -> ResponseEntity.ok(new MelhoriaDTO(melhoria))) // Converte para DTO
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMelhoria(@PathVariable Long id) {
        if (melhoriaService.buscarPorId(id).isPresent()) {
            melhoriaService.deletarMelhoria(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}