/*

        EM DESENVOLVIMENTO

*/

package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.StatusEtapa;

public class VerificacaoDTO {
    private Long id;
    private String indicadoresAnalisados;
    private String resultadosObtidos;
    private Boolean metasAtingidas;
    private String participantesVerificacao;
    private StatusEtapa statusVerificacao;
}