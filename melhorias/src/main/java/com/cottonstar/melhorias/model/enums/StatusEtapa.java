package com.cottonstar.melhorias.model.enums;

public enum StatusEtapa {
    INICIADO("Iniciado"),
    AGUARDANDO("Aguardando"),
    FINALIZADO("Finalizado");

    private final String descricao;

    StatusEtapa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}