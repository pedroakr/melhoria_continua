/*

        EM DESENVOLVIMENTO

*/

package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Aprendizado;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AprendizadoDTO {
    private Long id;
    private Long melhoriaId;
    private String descricaoAprendizado;
    private StatusEtapa statusAprendizado;

    public AprendizadoDTO(Aprendizado aprendizado){
        this.descricaoAprendizado = aprendizado.getDescricaoAprendizado();
        this.statusAprendizado = aprendizado.getStatusAprendizado();

        // Lógica segura para acessar dados de relacionamentos
        if (aprendizado.getMelhoria() != null && aprendizado.getMelhoria().getId() != null) {
            this.melhoriaId = aprendizado.getMelhoria().getId();
        }
    }
}