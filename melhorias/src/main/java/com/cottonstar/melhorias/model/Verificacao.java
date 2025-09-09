package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;

public class Verificacao {
    private String id;
    private String indicadoresAnalisados;   // Qual metodo foi usado para analisar a melhoria?
    private String resultadosObtidos;       // Resultado do metodo usado
    private Boolean metasAtingidas;         // Quais objetivos definidos no plano foram atingidos

    private String participantesVerificacao;           // Receberá os valores e agrupará por ; para armazenar no DB (Aplicar metodo para validar a existencia do usuaio)

    private StatusEtapa statusVerificacao;
}