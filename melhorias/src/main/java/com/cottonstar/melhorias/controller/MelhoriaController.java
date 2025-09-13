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
@RequiredArgsConstructor // A anotação do Lombok gera o construtor necessário
public class MelhoriaController {

    private final MelhoriaService melhoriaService;

    // --- Criar melhoria ---
    @PostMapping
    public ResponseEntity<Melhoria> criarMelhoria(@RequestBody Melhoria melhoria) {
        Melhoria novaMelhoria = melhoriaService.criarMelhoria(melhoria);
        return new ResponseEntity<>(novaMelhoria, HttpStatus.CREATED);
    }

    // --- Listar todas as melhorias ---
    @GetMapping
    public ResponseEntity<List<Melhoria>> listarMelhorias() {
        List<Melhoria> melhorias = melhoriaService.listarTodas();
        return new ResponseEntity<>(melhorias, HttpStatus.OK);
    }

    // --- Buscar melhoria por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<Melhoria> buscarMelhoriaPorId(@PathVariable Integer id) {
        Optional<Melhoria> melhoria = melhoriaService.buscarPorId(id);
        return melhoria
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // --- Atualizar melhoria ---
    @PutMapping("/{id}")
    public ResponseEntity<Melhoria> atualizarMelhoria(@PathVariable Integer id, @RequestBody Melhoria melhoriaAtualizada) {
        Optional<Melhoria> melhoriaExistente = melhoriaService.buscarPorId(id);

        if (melhoriaExistente.isPresent()) {
            melhoriaAtualizada.setId(Integer.valueOf(id));  // garante que estamos atualizando o ID correto
            Melhoria melhoriaSalva = melhoriaService.atualizarMelhoria(melhoriaAtualizada);
            return new ResponseEntity<>(melhoriaSalva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // --- Deletar melhoria ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMelhoria(@PathVariable Integer id) {
        Optional<Melhoria> melhoria = melhoriaService.buscarPorId(id);

        if (melhoria.isPresent()) {
            melhoriaService.deletarMelhoria(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}