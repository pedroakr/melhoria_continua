package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AprendizadoModel {
    private String id;
    private String pontosFortes;                // Breve descrição do ponto forte da equipe no decorrer do processo de melhoria
    private String pontosDeMelhoria;            // Breve descrição do que poderia ter sido melhor
    private LocalDate inicioAprendizado;              // Data inicial gerada automaticamente ao preencher e salvar
    private LocalDate fimAprendizado;                 // Data final gerada automaticamente ao alterar StatusEtapa para "Finalizado"
    private StatusEtapa statusExecucao;
}