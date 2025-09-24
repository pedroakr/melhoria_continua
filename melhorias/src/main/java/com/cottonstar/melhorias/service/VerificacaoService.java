package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.VerificacaoDTO;
import com.cottonstar.melhorias.dto.VerificacaoUpdateDTO;
import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.model.Verificacao;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VerificacaoService {
    private final MelhoriaRepository melhoriaRepository;

    @Transactional
    public VerificacaoDTO atualizarVerificacao(Long melhoriaId, VerificacaoUpdateDTO verificacaoUpdateDTO) {
        // 1. Encontra a Melhoria principal pelo ID
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada com o ID: " + melhoriaId));

        // 2. Obtém o Verificacao associado a essa Melhoria
        Verificacao verificacaoParaAtualizar = melhoria.getVerificacao();
        if (verificacaoParaAtualizar == null) {
            throw new IllegalStateException("Esta melhoria não possui um verificacao associado.");
        }

        // 3. Atualiza os campos do Verificacao com os dados do DTO
        verificacaoParaAtualizar.setIndicadoresAnalisados(verificacaoUpdateDTO.getIndicadoresAnalisados());
        verificacaoParaAtualizar.setResultadosObtidos(verificacaoUpdateDTO.getResultadosObtidos());
        verificacaoParaAtualizar.setValorRetornado(verificacaoUpdateDTO.getValorRetornado());
        verificacaoParaAtualizar.setTempoRetornado(verificacaoUpdateDTO.getTempoRetornado());
        verificacaoParaAtualizar.setStatusVerificacao(verificacaoUpdateDTO.getStatusVerificacao());

        /*

        -- Acrescentar regra --
        Ao clicar no botão salvar = Status iniciado
        Ao clicar no botão finalizar = Status finalizado

        */

        // 4. Salva a Melhoria. Como o relacionamento tem CascadeType.ALL,
        melhoriaRepository.save(melhoria);

        // Converte e retorna o DTO AQUI, dentro da transação
        return new VerificacaoDTO(verificacaoParaAtualizar);
    }
}
