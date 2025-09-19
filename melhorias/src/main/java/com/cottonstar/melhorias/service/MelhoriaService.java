package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.CriarMelhoriaDTO;
import com.cottonstar.melhorias.model.*;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.cottonstar.melhorias.model.enums.TamanhoMelhoria;
import com.cottonstar.melhorias.repository.MelhoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MelhoriaService {

    private final MelhoriaRepository melhoriaRepository;

    public Melhoria criarMelhoria(CriarMelhoriaDTO criarMelhoriaDTO) {
        // 1. Criar uma nova instância da entidade Melhoria
        Melhoria novaMelhoria = new Melhoria();
        Plano plano = new Plano();
        Execucao execucao = new Execucao();
        Verificacao verificacao = new Verificacao();
        Aprendizado aprendizado = new Aprendizado();

        // 2. ASSOCIE OS FILHOS À ENTIDADE "MÃE"
        novaMelhoria.setPlano(plano);
        novaMelhoria.setExecucao(execucao);
        novaMelhoria.setVerificacao(verificacao);
        novaMelhoria.setAprendizado(aprendizado);

        // 2. Mapear os dados do DTO para a entidade
        novaMelhoria.setTitulo(criarMelhoriaDTO.getTitulo());
        novaMelhoria.setTamanhoMelhoria(criarMelhoriaDTO.getTipo());
        novaMelhoria.setDepartamentoMelhoria(criarMelhoriaDTO.getDepartamentoMelhoria());
        novaMelhoria.setTipoRetorno(criarMelhoriaDTO.getTipoRetorno());
        novaMelhoria.setDescricao(criarMelhoriaDTO.getDescricao());

        if (novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.PEQUENA || novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.MEDIA) {
            novaMelhoria.getPlano().setStatusPlano(StatusEtapa.AGUARDANDO);
            novaMelhoria.getExecucao().setStatusExecucao(StatusEtapa.AGUARDANDO);
            novaMelhoria.getVerificacao().setStatusVerificacao(StatusEtapa.AGUARDANDO);
            novaMelhoria.getAprendizado().setStatusAprendizado(StatusEtapa.AGUARDANDO);
            novaMelhoria.setStatus(StatusEtapa.INICIADO);
        } else if (novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.GRANDE) {
            novaMelhoria.setStatus(StatusEtapa.AGUARDANDO);

            // ADICIONAR REGRA PARA APROVAÇÃO
            // BUSCAR NA TABELA USUARIO O USUARIO LOGADO
        }
        return melhoriaRepository.save(novaMelhoria);
    }

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