package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class MelhoriaService {

    private final MelhoriaRepository melhoriaRepository;

    public MelhoriaService(MelhoriaRepository melhoriaRepository) {
        this.melhoriaRepository = melhoriaRepository;
    }

    // LISTAR
    public List<Melhoria> getAll() {
        return melhoriaRepository.findAll();
    }

    // CRIAR
    public Melhoria save(Melhoria melhoria) {
        return melhoriaRepository.save(melhoria);
    }
    // DELETAR
    public void delete(Long id) {
        melhoriaRepository.deleteById(id);
    }
}