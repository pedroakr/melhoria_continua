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
        // Lógica de negócio para status iniciais com base no tamanho da melhoria
        if (melhoria.getTamanhoMelhoria() == TamanhoMelhoria.PEQUENA || melhoria.getTamanhoMelhoria() == TamanhoMelhoria.MEDIA) {
            melhoria.getPlano().setStatusPlano(StatusEtapa.INICIADO);
            melhoria.getExecucao().setStatusExecucao(StatusEtapa.AGUARDANDO);
            melhoria.getVerificacao().setStatusVerificacao(StatusEtapa.AGUARDANDO);
            melhoria.getAprendizado().setStatusAprendizado(StatusEtapa.AGUARDANDO);
            melhoria.setStatus(StatusEtapa.INICIADO);
        } else if (melhoria.getTamanhoMelhoria() == TamanhoMelhoria.GRANDE) {
            // Para melhorias grandes, o status inicial poderia ser "AGUARDANDO_APROVACAO"
            // Esta lógica pode ser expandida conforme a regra de negócio.
            melhoria.setStatus(StatusEtapa.AGUARDANDO); // Exemplo
        }
        return melhoriaRepository.save(melhoria);
    }

    public Optional<Melhoria> buscarPorId(Integer id) {
        return melhoriaRepository.findById(id);
    }

    public List<Melhoria> listarTodas() {
        return melhoriaRepository.findAll();
    }

    public Melhoria atualizarMelhoria(Melhoria melhoria) {
        return melhoriaRepository.save(melhoria);
    }

    public void deletarMelhoria(Integer id) {
        melhoriaRepository.deleteById(id);
    }
}