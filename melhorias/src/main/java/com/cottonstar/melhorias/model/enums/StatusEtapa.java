package com.cottonstar.melhorias.model.enums;

import lombok.Getter;

@Getter
public enum StatusEtapa {
    INICIADO("Iniciado"),
    AGUARDANDO("Aguardando"),
    FINALIZADO("Finalizado");

    private final String descricao;

    StatusEtapa(String descricao) {
        this.descricao = descricao;
    }
}