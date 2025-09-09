package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;

public class Execucao {
    private String id;
    private String atividadesRealizadas;        // Descrição das estapas do processo de melhoria que foram realizados
    private Usuario executor;                   // Usuario que executou a etapa

    private String participantesExecucao;       // Receberá os valores e agrupará por ; para armazenar no DB

    private StatusEtapa statusExecucao;
}