package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.AprendizadoDTO;
import com.cottonstar.melhorias.dto.AprendizadoUpdateDTO;
import com.cottonstar.melhorias.model.Aprendizado;
import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AprendizadoService {
    private final MelhoriaRepository melhoriaRepository;

    @Transactional
    public AprendizadoDTO atualizarAprendizado(Long melhoriaId, AprendizadoUpdateDTO aprendizadoUpdateDTO) {
        // 1. Encontra a Melhoria principal pelo ID
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada com o ID: " + melhoriaId));

        // 2. Obtém o Aprendizado associado a essa Melhoria
        Aprendizado aprendizadoParaAtualizar = melhoria.getAprendizado();
        if (aprendizadoParaAtualizar == null) {
            throw new IllegalStateException("Esta melhoria não possui um Aprendizado associado.");
        }

        // 3. Atualiza os campos do Aprendizado com os dados do DTO
        aprendizadoParaAtualizar.setDescricaoAprendizado(aprendizadoUpdateDTO.getDescricaoAprendizado());
        aprendizadoParaAtualizar.setStatusAprendizado(aprendizadoUpdateDTO.getStatusAprendizado());

        /*
        -- Acrescentar regra --
        Ao clicar no botão salvar = Status iniciado
        Ao clicar no botão finalizar = Status finalizado
        */

        // 4. Salva a Melhoria. Como o relacionamento tem CascadeType.ALL,
        melhoriaRepository.save(melhoria);

        // Converte e retorna o DTO AQUI, dentro da transação
        return new AprendizadoDTO(aprendizadoParaAtualizar);
    }

}
