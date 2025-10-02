package com.cottonstar.melhorias.model.enums;

import lombok.Getter;

@Getter
public enum StatusMelhoria {
    EM_APROVACAO("Em aprovação"),
    APROVADO("Aprovado"),
    REJEITADO("Rejeitado"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO("Concluído");

    private final String descricao;

    StatusMelhoria(String descricao) {
        this.descricao = descricao;
    }
}





/*  1 - SERÁ CRIADO NOVA MELHORIA
*   2 - APÓS PREENCHIMENTO DE TITULO, USUARIO (AUTOMATICO), DEPARTAMENTO E TIPO E "ADICIONAR"
*
*       -> SE TIPO = PEQUENA/MEDIA
*           -> STATUS       - PLANO
*               -> PLANO        - INICIADO
*               -> Execucao     - AGUARDANDO
*               -> VERIFICACAO  - AGUARDANDO
*               -> APRENDIZADO  - AGUARDANDO
*
*       -> SE TIPO = GRANDE
*           -> STATUS       - EM_APROVACAO
*               -> APOS APROVADO:
*                   -> STATUS       - PLANO
*                       -> PLANO        - INICIADO
*                       -> Execucao     - AGUARDANDO
*                       -> VERIFICACAO  - AGUARDANDO
*                       -> APRENDIZADO  - AGUARDANDO
*
*   3 - SE PLANO = FINALIZADO
*               -> STATUS       - EXECUCAO
*                   -> PLANO        - FINALIZADO
*                   -> EXECUCAO     - INICIADO
*                   -> VERIFICACAO  - AGUARDANDO
*                   -> APRENDIZADO  - AGUARDANDO
*
*   4 - SE EXECUCAO = FINALIZADO
*               -> STATUS       - VERIFICACAO
*                   -> PLANO        - FINALIZADO
*                   -> EXECUCAO     - FINALIZADO
*                   -> VERIFICACAO  - INICIADO
*                   -> APRENDIZADO  - AGUARDANDO
*
*    5 - SE VERIFICACAO = FINALIZADO
*               -> STATUS       - APRENDIZADO
*                   -> PLANO        - FINALIZADO
*                   -> EXECUCAO     - FINALIZADO
*                   -> VERIFICACAO  - FINALIZADO
*
*
*     6 - SE APRENDIZADO = FINALIZADO
*               -> STATUS       - VALIDANDO
*                   - SE VALIDADO:
*                       -> STATUS       - FINALIZADO
*                           -> PLANO        - FINALIZADO
*                           -> EXECUCAO     - FINALIZADO
*                           -> VERIFICACAO  - FINALIZADO
*                           -> APRENDIZADO  - FINALIZADO
*
* */