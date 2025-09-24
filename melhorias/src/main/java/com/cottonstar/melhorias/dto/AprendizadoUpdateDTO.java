package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprendizadoUpdateDTO {
    private String descricaoAprendizado;
    private StatusEtapa statusAprendizado;
}
