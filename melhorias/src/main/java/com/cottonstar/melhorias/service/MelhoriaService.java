package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // A anotação do Lombok gera o construtor necessário
public class MelhoriaService {

    private final MelhoriaRepository melhoriaRepository;

    // Construtor manual foi removido daqui para evitar duplicidade.

    public Melhoria criarMelhoria(Melhoria melhoria) {
        return melhoriaRepository.save(melhoria);
    }

    public Optional<Melhoria> buscarPorId(String id) {
        return melhoriaRepository.findById(id);
    }

    public List<Melhoria> listarTodas() {
        return melhoriaRepository.findAll();
    }

    public Melhoria atualizarMelhoria(Melhoria melhoria) {
        return melhoriaRepository.save(melhoria);
    }

    public void deletarMelhoria(String id) {
        melhoriaRepository.deleteById(id);
    }
}