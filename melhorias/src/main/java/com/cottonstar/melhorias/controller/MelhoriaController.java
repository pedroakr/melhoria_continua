package com.cottonstar.melhorias.controller;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.service.MelhoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/melhorias")
@RequiredArgsConstructor
public class MelhoriaController {

    private final MelhoriaService melhoriaService;

    @PostMapping
    public ResponseEntity<Melhoria> criarMelhoria(@RequestBody Melhoria melhoria) {
        Melhoria novaMelhoria = melhoriaService.criarMelhoria(melhoria);
        return new ResponseEntity<>(novaMelhoria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Melhoria>> listarMelhorias() {
        List<Melhoria> melhorias = melhoriaService.listarTodas();
        return new ResponseEntity<>(melhorias, HttpStatus.OK);
    }

    // CORREÇÃO: Alterado de Integer para Long
    @GetMapping("/{id}")
    public ResponseEntity<Melhoria> buscarMelhoriaPorId(@PathVariable Long id) {
        Optional<Melhoria> melhoria = melhoriaService.buscarPorId(id);
        return melhoria
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // CORREÇÃO: Alterado de Integer para Long
    @PutMapping("/{id}")
    public ResponseEntity<Melhoria> atualizarMelhoria(@PathVariable Long id, @RequestBody Melhoria melhoriaAtualizada) {
        return melhoriaService.buscarPorId(id)
                .map(melhoriaExistente -> {
                    melhoriaAtualizada.setId(id); // Garante que o ID correto seja atualizado
                    Melhoria melhoriaSalva = melhoriaService.atualizarMelhoria(melhoriaAtualizada);
                    return new ResponseEntity<>(melhoriaSalva, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // CORREÇÃO: Alterado de Integer para Long
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMelhoria(@PathVariable Long id) {
        if (melhoriaService.buscarPorId(id).isPresent()) {
            melhoriaService.deletarMelhoria(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}