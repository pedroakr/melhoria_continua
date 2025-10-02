package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.*;
import com.cottonstar.melhorias.model.*;
import com.cottonstar.melhorias.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.cottonstar.melhorias.dto.ArquivoDTO;
import com.cottonstar.melhorias.repository.ArquivoRepository;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExecucaoService {

    private final MelhoriaRepository melhoriaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ParticipacaoExecucaoRepository participacaoExecucaoRepository;
    private final ComentarioExecucaoRepository comentarioRepository; // Adicione
    private final ArquivoRepository arquivoRepository;
    private final FileStorageService fileStorageService;

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

    // --- METODO PARA ADICIONAR PARTICIPANTE ---
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

    // --- METODO PARA ADICIONAR COMENTÁRIO ---
    @Transactional
    public ComentarioDTO adicionarComentario(Long melhoriaId, ComentarioCreateDTO dto, String emailUsuarioLogado) {
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada com o ID: " + melhoriaId));
        Execucao execucao = melhoria.getExecucao();
        Usuario autor = usuarioRepository.findByEmail(emailUsuarioLogado)
                .orElseThrow(() -> new EntityNotFoundException("Usuário autor não encontrado."));

        ComentarioExecucao novoComentario = new ComentarioExecucao();
        novoComentario.setMensagem(dto.getMensagem());
        novoComentario.setExecucao(execucao);
        novoComentario.setAutor(autor);

        ComentarioExecucao comentarioSalvo = comentarioRepository.save(novoComentario);
        return new ComentarioDTO(comentarioSalvo);
    }

    // --- NOVO METODO PARA ATUALIZAR COMENTÁRIO ---
    @Transactional
    public ComentarioDTO atualizarComentario(Long comentarioId, ComentarioUpdateDTO dto, String emailUsuarioLogado) throws AccessDeniedException {
        ComentarioExecucao comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com o ID: " + comentarioId));

        Usuario usuarioLogado = usuarioRepository.findByEmail(emailUsuarioLogado)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));

        // VERIFICAÇÃO DE SEGURANÇA: Só o autor original pode editar.
        if (!comentario.getAutor().getId().equals(usuarioLogado.getId())) {
            throw new AccessDeniedException("Você não tem permissão para editar este comentário.");
        }

        comentario.setMensagem(dto.getMensagem());
        ComentarioExecucao comentarioSalvo = comentarioRepository.save(comentario);
        return new ComentarioDTO(comentarioSalvo);
    }

    // --- NOVO METODO PARA UPLOAD ---
    @Transactional
    public ArquivoDTO anexarArquivo(Long melhoriaId, MultipartFile file) {
        Melhoria melhoria = melhoriaRepository.findById(melhoriaId)
                .orElseThrow(() -> new EntityNotFoundException("Melhoria não encontrada."));
        Execucao execucao = melhoria.getExecucao();

        String nomeArmazenado = fileStorageService.storeFile(file);

        Arquivo novoArquivo = new Arquivo();
        novoArquivo.setNomeOriginal(StringUtils.cleanPath(file.getOriginalFilename()));
        novoArquivo.setNomeArmazenado(nomeArmazenado);
        novoArquivo.setContentType(file.getContentType());
        novoArquivo.setTamanho(file.getSize());
        novoArquivo.setExecucao(execucao);

        Arquivo arquivoSalvo = arquivoRepository.save(novoArquivo);
        return new ArquivoDTO(arquivoSalvo);
    }

    // --- NOVO METODO PARA DELEÇÃO ---
    @Transactional
    public void deletarAnexo(Long arquivoId) {
        Arquivo arquivo = arquivoRepository.findById(arquivoId)
                .orElseThrow(() -> new EntityNotFoundException("Arquivo não encontrado."));

        fileStorageService.deleteFile(arquivo.getNomeArmazenado());
        arquivoRepository.delete(arquivo);
    }
}
