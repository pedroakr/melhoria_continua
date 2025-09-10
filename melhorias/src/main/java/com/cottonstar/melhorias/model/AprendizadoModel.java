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
    private String descricaoAprendizado;        // DESCRIÇÃO DO QUE FOI APRENDIDO
    private LocalDate inicioAprendizado;        // DATA INICIAL            { IF statusAprendizado == "INICIADO" { inicioAprendizado = DATA ATUAL } }
    private LocalDate fimAprendizado;           // DATA QUE FOI FINALIZADO { IF statusAprendizado == "FINALIZADO" { fimAprendizado = DATA ATUAL } }
    private StatusEtapa statusAprendizado;      // STATUS ATUAL { IF statusVerificacao == "AGUARDANDO" { statusAprendizado = "AGUARDANDO"  } IF statusVerificacao == "FINALIZADO" { statusAprendizado = "INICIADO" } IF PRESS_BOTAO_FINALIZAR = TRUE { statusAprendizado = "FINALIZADO" } }
}