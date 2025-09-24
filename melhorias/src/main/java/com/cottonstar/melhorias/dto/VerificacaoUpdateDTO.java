package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VerificacaoUpdateDTO {
    private String indicadoresAnalisados;
    private String resultadosObtidos;
    private BigDecimal valorRetornado;
    private int tempoRetornado;
    // ---------------------------------- VERIFICAR ----------------------------------
    //private String participantesVerificacao; /* VERIFICAR UMA FORMA DE ARMAZENAR NA TABELA DE PARTICIPANTES ANEXANDO ID DA VERIFICAÇÃO */
    // -------------------------------------------------------------------------------
    private StatusEtapa statusVerificacao;
}
