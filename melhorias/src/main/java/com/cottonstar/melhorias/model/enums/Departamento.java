package com.cottonstar.melhorias.model.enums;

import lombok.Getter;

@Getter
public enum Departamento {
    TI("TI"),
    PRODUCAO("Produção"),
    COMPRAS("Compras"),
    FINANCEIRO("Financeiro"),
    RH("RH"),
    MARKETING("Marketing"),
    GERAL("Geral");

    private final String descricao;

    Departamento(String descricao) {
        this.descricao = descricao;
    }
}