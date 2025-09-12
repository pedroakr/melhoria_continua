package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.MelhoriaModel;
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

    public MelhoriaModel criarMelhoria(MelhoriaModel melhoriaModel) {
        return melhoriaRepository.save(melhoriaModel);
    }

    public Optional<MelhoriaModel> buscarPorId(String id) {
        return melhoriaRepository.findById(id);
    }

    public List<MelhoriaModel> listarTodas() {
        return melhoriaRepository.findAll();
    }

    public MelhoriaModel atualizarMelhoria(MelhoriaModel melhoriaModel) {
        return melhoriaRepository.save(melhoriaModel);
    }

    public void deletarMelhoria(String id) {
        melhoriaRepository.deleteById(id);
    }
}