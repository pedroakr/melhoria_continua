package com.cottonstar.melhorias.model.enums;

public enum Departamento {
    TI("TI"),
    PRODUCAO("Produção"),
    COMPRAS("Compras"),
    FINANCEIRO("Financeiro"),
    RH("RH"),
    MARKETING("Marketing");

    private final String descricao;

    Departamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}