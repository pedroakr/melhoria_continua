package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.AdicionarParticipantesDTO;
import com.cottonstar.melhorias.dto.ExecucaoDTO;
import com.cottonstar.melhorias.dto.ExecucaoUpdateDTO;
import com.cottonstar.melhorias.dto.ParticipacaoExecucaoDTO;
import com.cottonstar.melhorias.model.Execucao;
import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.model.ParticipacaoExecucao;
import com.cottonstar.melhorias.model.Usuario;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import com.cottonstar.melhorias.repository.ParticipacaoExecucaoRepository;
import com.cottonstar.melhorias.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExecucaoService {

    private final MelhoriaRepository melhoriaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ParticipacaoExecucaoRepository participacaoExecucaoRepository;

    @Transactional
    public ExecucaoDTO atualizarExecucao(Long melhoriaId, ExecucaoUpdateDTO execucaoUpdateDTO) {
        // 1. Encontra a Melhoria principal pelo ID
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada com o ID: " + melhoriaId));

        // 2. Obtém a Execução associada a essa Melhoria
        Execucao execucaoParaAtualizar = melhoria.getExecucao();
        if (execucaoParaAtualizar == null) {
            throw new IllegalStateException("Esta melhoria não possui uma etapa de execução associada.");
        }

        // 3. Atualiza os campos da Execução com os dados do DTO
        execucaoParaAtualizar.setStatusExecucao(execucaoUpdateDTO.getStatusExecucao());

        // 4. Salva a entidade Melhoria (que por cascata, salva a Execução)
        melhoriaRepository.save(melhoria);

        // 5. Converte a entidade atualizada para DTO e a retorna
        return new ExecucaoDTO(execucaoParaAtualizar);
    }

    // --- MÉTODO PARA ADICIONAR PARTICIPANTE ---
    @Transactional
    public List<ParticipacaoExecucaoDTO> adicionarParticipantes(Long melhoriaId, AdicionarParticipantesDTO dto) {
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada com o ID: " + melhoriaId));

        Execucao execucao = melhoria.getExecucao();
        if (execucao == null) {
            throw new IllegalStateException("Esta melhoria não possui uma etapa de execução.");
        }

        // Pega os IDs dos usuários que já são participantes para evitar duplicatas
        List<Long> idsJaParticipantes = execucao.getParticipantesExecucao().stream()
                .map(p -> p.getUsuario().getId())
                .collect(Collectors.toList());

        List<ParticipacaoExecucao> novasParticipacoes = new ArrayList<>();

        // Itera sobre a lista de IDs recebida
        for (Long usuarioId : dto.getUsuarioIds()) {
            // Se o usuário já participa, pula para o próximo
            if (idsJaParticipantes.contains(usuarioId)) {
                continue;
            }

            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + usuarioId));

            ParticipacaoExecucao novaParticipacao = new ParticipacaoExecucao();
            novaParticipacao.setExecucao(execucao);
            novaParticipacao.setUsuario(usuario);
            novasParticipacoes.add(novaParticipacao);
        }

        // Salva todas as novas participações de uma vez
        List<ParticipacaoExecucao> participacoesSalvas = participacaoExecucaoRepository.saveAll(novasParticipacoes);

        // Converte a lista de entidades salvas para uma lista de DTOs
        return participacoesSalvas.stream()
                .map(ParticipacaoExecucaoDTO::new)
                .collect(Collectors.toList());
    }
}
