/*

        EM DESENVOLVIMENTO

*/

package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Execucao;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ExecucaoDTO {
    private Long id;
    private StatusEtapa statusExecucao;
    private LocalDate inicioExecucao;
    private LocalDate fimExecucao;

    public ExecucaoDTO(Execucao execucao) {
        this.id = execucao.getId();
        this.statusExecucao = execucao.getStatusExecucao();
        this.inicioExecucao = execucao.getInicioExecucao();
        this.fimExecucao = execucao.getFimExecucao();
    }
}