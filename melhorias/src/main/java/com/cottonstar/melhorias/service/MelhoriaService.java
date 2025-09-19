package com.cottonstar.melhorias.service;

import com.cottonstar.melhorias.dto.CriarMelhoriaDTO;
import com.cottonstar.melhorias.model.Melhoria;
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

        // 2. Mapear os dados do DTO para a entidade
        novaMelhoria.setTitulo(criarMelhoriaDTO.getTitulo());
        novaMelhoria.setTamanhoMelhoria(criarMelhoriaDTO.getTipo());
        novaMelhoria.setDepartamentoMelhoria(criarMelhoriaDTO.getDepartamentoMelhoria());

        if (novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.PEQUENA || novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.MEDIA) {
            novaMelhoria.getPlano().setStatusPlano(StatusEtapa.INICIADO);
            novaMelhoria.getExecucao().setStatusExecucao(StatusEtapa.AGUARDANDO);
            novaMelhoria.getVerificacao().setStatusVerificacao(StatusEtapa.AGUARDANDO);
            novaMelhoria.getAprendizado().setStatusAprendizado(StatusEtapa.AGUARDANDO);
            novaMelhoria.setStatus(StatusEtapa.INICIADO);
        } else if (novaMelhoria.getTamanhoMelhoria() == TamanhoMelhoria.GRANDE) {
            novaMelhoria.setStatus(StatusEtapa.AGUARDANDO);
            // ADICIONAR REGRA PARA APROVAÇÃO
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