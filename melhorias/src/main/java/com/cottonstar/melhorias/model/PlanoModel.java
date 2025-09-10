package com.cottonstar.melhorias.model;
import com.cottonstar.melhorias.model.enums.StatusEtapa;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanoModel {
    private String id;
    private String analiseProblema;     // Breve identificação do Problema
    private String estrategia;          // Breve resumo do pretende-se fazer
    private String objetivos;           // Breve descrição do objetivo da melhoria
    private LocalDate inicioPlano;      // Data inicial gerada automaticamente ao preencher e salvar
    private LocalDate fimPlano;         // Data final gerada automaticamente ao alterar StatusEtapa para "Finalizado"
    private StatusEtapa statusPlano;
}