package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.CriarMelhoriaDTO;
import com.cottonstar.melhorias.dto.MelhoriaDTO;
import com.cottonstar.melhorias.model.*;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.cottonstar.melhorias.model.enums.TamanhoMelhoria;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import com.cottonstar.melhorias.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MelhoriaService {

    private final MelhoriaRepository melhoriaRepository;
    private final UsuarioRepository usuarioRepository; // Adicione o repositório de usuário

    @Transactional
    public Melhoria criarMelhoria(CriarMelhoriaDTO criarMelhoriaDTO, String emailUsuarioLogado) {
        // 1. Buscar o usuário responsável que está logado
        Usuario responsavel = usuarioRepository.findByEmail(emailUsuarioLogado)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + emailUsuarioLogado));

        // 2. Criar as instâncias das entidades
        Melhoria novaMelhoria = new Melhoria();
        Plano plano = new Plano();
        Execucao execucao = new Execucao();
        Verificacao verificacao = new Verificacao();
        Aprendizado aprendizado = new Aprendizado();

        // 3. Mapear os dados do DTO
        novaMelhoria.setTitulo(criarMelhoriaDTO.getTitulo());
        novaMelhoria.setTamanhoMelhoria(criarMelhoriaDTO.getTamanhoMelhoria());
        novaMelhoria.setDepartamentoMelhoria(criarMelhoriaDTO.getDepartamentoMelhoria());
        novaMelhoria.setTipoRetorno(criarMelhoriaDTO.getTipoRetorno());
        novaMelhoria.setDescricao(criarMelhoriaDTO.getDescricao());

        // 4. Atribuir o usuário responsável
        novaMelhoria.setResponsavel(responsavel);

        // 5. Associar as etapas à melhoria
        novaMelhoria.setPlano(plano);
        novaMelhoria.setExecucao(execucao);
        novaMelhoria.setVerificacao(verificacao);
        novaMelhoria.setAprendizado(aprendizado);

        // Lógica de status
        if (novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.PEQUENA || novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.MEDIA) {
            plano.setStatusPlano(StatusEtapa.AGUARDANDO);
            execucao.setStatusExecucao(StatusEtapa.AGUARDANDO);
            verificacao.setStatusVerificacao(StatusEtapa.AGUARDANDO);
            aprendizado.setStatusAprendizado(StatusEtapa.AGUARDANDO);
            novaMelhoria.setStatus(StatusEtapa.INICIADO);

            // --- CORREÇÃO CRÍTICA AQUI ---
            // Atribui valores padrão aos campos não nulos de Verificacao
            verificacao.setIndicadoresAnalisados("NA");
            verificacao.setResultadosObtidos("NA");

        } else if (novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.GRANDE) {
            novaMelhoria.setStatus(StatusEtapa.AGUARDANDO);
            // ... (regras futuras)
        }

        return melhoriaRepository.save(novaMelhoria);
    }

    // --- NOVO METODO PARA LISTAR MELHORIAS DO USUÁRIO LOGADO ---
    public List<MelhoriaDTO> listarMelhoriasPorUsuario(String emailUsuarioLogado) {
        // 1. Usa o novo método do repositório para buscar as entidades
        List<Melhoria> melhorias = melhoriaRepository.findByResponsavelEmail(emailUsuarioLogado);

        // 2. Converte a lista de entidades para uma lista de DTOs
        return melhorias.stream()
                .map(MelhoriaDTO::new) // Usa o construtor do MelhoriaDTO
                .collect(Collectors.toList());
    }

    // --- MÉTODOS DE APOIO EXISTENTES ---
    public Optional<Melhoria> buscarPorId(Long id) {
        return melhoriaRepository.findById(id);
    }

    public List<Melhoria> listarTodas() {
        return melhoriaRepository.findAll();
    }

    public Melhoria atualizarMelhoria(Melhoria melhoria) {
        return melhoriaRepository.save(melhoria);
    }

    public void deletarMelhoria(Long id) {
        melhoriaRepository.deleteById(id);
    }
}