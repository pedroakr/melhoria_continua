package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_execucao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExecucaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate inicioExecucao;                                   // DATA INICIAL GERADA AUTOMATICAMENTE
    private LocalDate fimExecucao;                                      // DATA FINAL GERADA AUTOMATICAMENTE
    private ParticipacaoExecucaoModel participantesExecucao;

    @OneToMany(mappedBy = "execucaoFk", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioModel> comentariosExecucao;                 // HISTORICO DE AÇÕES COMENTADAS

    // Lista de anexos
    private List<ArquivoModel> anexosExecucao = new ArrayList<>();              // ANEXOS INSERIDOS

    private double valorRetornado;                                      // VALOR FINANCEIRO RETORNADO
    private StatusEtapa statusExecucao;                                 // STATUS { IF statusPlano == "INICIADO" { statusExecucao = "AGUARDANDO" } IF statusPlano == "FINALIZADO" { statusExecucao = "INICIADO" } IF PRESIONADO_BOTAO_FINALIZAR == TRUE { statusExecucao = "FINALIZADO" } }

}