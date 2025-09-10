package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExecucaoModel {
    private String id;
    private String atividadesRealizadas;        // Descrição das estapas do processo de melhoria que foram realizados
    private LocalDate inicioExecucao;              // Data inicial gerada automaticamente ao preencher e salvar
    private LocalDate fimExecucao;                 // Data final gerada automaticamente ao alterar StatusEtapa para "Finalizado"
    private StatusEtapa statusExecucao;
}