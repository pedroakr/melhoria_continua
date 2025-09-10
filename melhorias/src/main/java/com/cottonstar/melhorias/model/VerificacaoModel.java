package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificacaoModel {
    private String id;
    private String indicadoresAnalisados;   // Qual metodo foi usado para analisar a melhoria?
    private String resultadosObtidos;       // Resultado do metodo usado
    private Boolean metasAtingidas;         // Quais objetivos definidos no plano foram atingidos
    private LocalDate inicioPlano;          // Data inicial gerada automaticamente ao preencher e salvar
    private LocalDate fimPlano;             // Data final gerada automaticamente ao alterar StatusEtapa para "Finalizado"
    private StatusEtapa statusVerificacao;  // STATUS { IF statusExecucao == "INICIADO" { statusVerificacao = "AGUARDANDO" } IF statusExecucao == "FINALIZADO" { statusVerificacao = "INICIADO" } IF PRESIONADO_BOTAO_FINALIZAR == TRUE { statusVerificacao = "FINALIZADO" }}
}