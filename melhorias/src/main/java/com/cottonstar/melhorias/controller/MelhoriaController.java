package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.model.MelhoriaModel;
import com.cottonstar.melhorias.service.MelhoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/melhorias")
@RequiredArgsConstructor // A anotação do Lombok gera o construtor necessário
public class MelhoriaController {

    private final MelhoriaService melhoriaService;

    // Construtor manual foi removido daqui para evitar duplicidade.

    // --- Criar melhoria ---
    @PostMapping
    public ResponseEntity<MelhoriaModel> criarMelhoria(@RequestBody MelhoriaModel melhoriaModel) {
        MelhoriaModel novaMelhoriaModel = melhoriaService.criarMelhoria(melhoriaModel);
        return new ResponseEntity<>(novaMelhoriaModel, HttpStatus.CREATED);
    }

    // --- Listar todas as melhorias ---
    @GetMapping
    public ResponseEntity<List<MelhoriaModel>> listarMelhorias() {
        List<MelhoriaModel> melhoriaModels = melhoriaService.listarTodas();
        return new ResponseEntity<>(melhoriaModels, HttpStatus.OK);
    }

    // --- Buscar melhoria por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<MelhoriaModel> buscarMelhoriaPorId(@PathVariable String id) {
        Optional<MelhoriaModel> melhoria = melhoriaService.buscarPorId(id);
        return melhoria
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // --- Atualizar melhoria ---
    @PutMapping("/{id}")
    public ResponseEntity<MelhoriaModel> atualizarMelhoria(@PathVariable String id, @RequestBody MelhoriaModel melhoriaModelAtualizada) {
        Optional<MelhoriaModel> melhoriaExistente = melhoriaService.buscarPorId(id);

        if (melhoriaExistente.isPresent()) {
            melhoriaModelAtualizada.setId(id);  // garante que estamos atualizando o ID correto
            MelhoriaModel melhoriaModelSalva = melhoriaService.atualizarMelhoria(melhoriaModelAtualizada);
            return new ResponseEntity<>(melhoriaModelSalva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // --- Deletar melhoria ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMelhoria(@PathVariable String id) {
        Optional<MelhoriaModel> melhoria = melhoriaService.buscarPorId(id);

        if (melhoria.isPresent()) {
            melhoriaService.deletarMelhoria(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}