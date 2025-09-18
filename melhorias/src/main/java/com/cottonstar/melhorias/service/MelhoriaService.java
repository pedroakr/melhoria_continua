package com.cottonstar.melhorias.service;

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

    public Melhoria criarMelhoria(Melhoria melhoria) {
        if (melhoria.getTamanhoMelhoria() == TamanhoMelhoria.PEQUENA || melhoria.getTamanhoMelhoria() == TamanhoMelhoria.MEDIA) {
            melhoria.getPlano().setStatusPlano(StatusEtapa.INICIADO);
            melhoria.getExecucao().setStatusExecucao(StatusEtapa.AGUARDANDO);
            melhoria.getVerificacao().setStatusVerificacao(StatusEtapa.AGUARDANDO);
            melhoria.getAprendizado().setStatusAprendizado(StatusEtapa.AGUARDANDO);
            melhoria.setStatus(StatusEtapa.INICIADO);
        } else if (melhoria.getTamanhoMelhoria() == TamanhoMelhoria.GRANDE) {
            melhoria.setStatus(StatusEtapa.AGUARDANDO);
        }
        return melhoriaRepository.save(melhoria);
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