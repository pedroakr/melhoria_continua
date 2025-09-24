/*

        EM DESENVOLVIMENTO

*/

package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Verificacao;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class VerificacaoDTO {
    private Long id;
    private  Long melhoriaId;
    private String indicadoresAnalisados;
    private String resultadosObtidos;
    private BigDecimal valorRetornado;
    private int tempoRetornado;
    //rivate String participantesVerificacao;
    private StatusEtapa statusVerificacao;

    public VerificacaoDTO(Verificacao verificacao){
        this.id = verificacao.getId();
        this.indicadoresAnalisados = verificacao.getIndicadoresAnalisados();
        this.resultadosObtidos = verificacao.getResultadosObtidos();
        this.valorRetornado = verificacao.getValorRetornado();
        this.tempoRetornado = verificacao.getTempoRetornado();
        this.statusVerificacao = verificacao.getStatusVerificacao();

        // Lógica segura para acessar dados de relacionamentos
        if (verificacao.getMelhoria() != null && verificacao.getMelhoria().getId() != null) {
            this.melhoriaId = verificacao.getMelhoria().getId();
        }
    }
}