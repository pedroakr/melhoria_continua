package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.PlanoUpdateDTO;
import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.model.Plano;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final MelhoriaRepository melhoriaRepository;

    @Transactional
    public Plano atualizarPlano(Long melhoriaId, PlanoUpdateDTO planoUpdateDTO) {
        // 1. Encontra a Melhoria principal pelo ID
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada com o ID: " + melhoriaId));

        // 2. Obtém o Plano associado a essa Melhoria
        Plano planoParaAtualizar = melhoria.getPlano();
        if (planoParaAtualizar == null) {
            throw new IllegalStateException("Esta melhoria não possui um plano associado.");
        }

        // 3. Atualiza os campos do Plano com os dados do DTO
        planoParaAtualizar.setAnaliseProblema(planoUpdateDTO.getAnaliseProblema());
        planoParaAtualizar.setEstrategia(planoUpdateDTO.getEstrategia());
        planoParaAtualizar.setObjetivos(planoUpdateDTO.getObjetivos());
        planoParaAtualizar.setExpectativaFinanceira(planoUpdateDTO.getExpectativaFinanceira());
        planoParaAtualizar.setExpectativaTempo(planoUpdateDTO.getExpectativaTempo());
        planoParaAtualizar.setStatusPlano(planoUpdateDTO.getStatusPlano());

        // 4. Salva a Melhoria. Como o relacionamento tem CascadeType.ALL,
        // as alterações no Plano serão salvas automaticamente.
        melhoriaRepository.save(melhoria);

        return planoParaAtualizar;
    }
}