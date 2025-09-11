package com.cottonstar.melhorias.model;
import com.cottonstar.melhorias.model.enums.StatusEtapa;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_plano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String analiseProblema;                     // DESCRIÇÃO DO PROBLEMA
    private String estrategia;                          // O QUE SERÁ FEITO
    private String objetivos;                           // RESULTADO ESPERADO
    private ParticipacaoPlanoModel participantesPlano;  // USUARIOS QUE PARTICIPARÃO
    private double expectativaFinanceira;               // RETORNO FINANCEIRO ESPERADO R$   { IF TipoRetorno == "FINANCEIRO" }
    private LocalDate inicioPlano;                      // DATA INICIDA (GERADO AO STARTAR) { IF statusPlano == "INICIADO" }
    private LocalDate fimPlano;                         // DATA FINAL (GERADO AO FINALIZAR) { IF statusPlano == "FINALIZADO" }
    private StatusEtapa statusPlano;                    // STATUS ATUAL { AO CRIAR MELHORIA (AÇÃO) STARTAR COMO "INICIADO", APÓS O USUARIO PODE ALTERAR PARA FINALIZADO QUANDO ACHAR NECESSARIO
}