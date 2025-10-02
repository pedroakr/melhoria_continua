package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.PlanoDTO;
import com.cottonstar.melhorias.dto.PlanoUpdateDTO;
import com.cottonstar.melhorias.model.*;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
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
    public PlanoDTO atualizarPlano(Long melhoriaId, PlanoUpdateDTO planoUpdateDTO) {
        // 1. Encontra a Melhoria principal pelo ‘ID’
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada com o ID: " + melhoriaId));

        // 2. Obtém o Plano associado a essa Melhoria
        Plano planoParaAtualizar = melhoria.getPlano();
        if (planoParaAtualizar == null) {
            throw new IllegalStateException("Esta melhoria não possui um plano associado.");
        }

        // 3. Obter as outras etapas para atualizar seus status
        Execucao execucao = melhoria.getExecucao();
        Verificacao verificacao = melhoria.getVerificacao();
        Aprendizado aprendizado = melhoria.getAprendizado();

        // 4. Atualiza os campos do Plano com os dados do DTO
        planoParaAtualizar.setAnaliseProblema(planoUpdateDTO.getAnaliseProblema());
        planoParaAtualizar.setEstrategia(planoUpdateDTO.getEstrategia());
        planoParaAtualizar.setObjetivos(planoUpdateDTO.getObjetivos());
        planoParaAtualizar.setExpectativaFinanceira(planoUpdateDTO.getExpectativaFinanceira());
        planoParaAtualizar.setExpectativaTempo(planoUpdateDTO.getExpectativaTempo());
        planoParaAtualizar.setStatusPlano(planoUpdateDTO.getStatusPlano());

        // 5. Aplica a regra de negócio baseada no status enviado pelo front-end
        StatusEtapa novoStatusPlano = planoUpdateDTO.getStatusPlano();
        planoParaAtualizar.setStatusPlano(novoStatusPlano);

        melhoria.setStatus(StatusMelhoria.EM_ANDAMENTO);

        if (novoStatusPlano == StatusEtapa.FINALIZADO) {
            // Lógica para "Finalizar"
            execucao.setStatusExecucao(StatusEtapa.INICIADO);
        }

        // 6. Salva a Melhoria. A anotação @Transactional garante que todas as alterações
        // (no plano, execução, etc.) sejam salvas juntas.
        melhoriaRepository.save(melhoria);

        // 7. Converte e retorna o DTO com os dados atualizados
        return new PlanoDTO(planoParaAtualizar);
    }
}