package com.cottonstar.melhorias.model.enums;

public enum PerfilAcesso {
    ADMIN("Administrador"),
    GERENCIA("Gerência"),
    GESTOR("Gestor"),
    COLABORADOR("Colaborador");

    private final String descricao;

    PerfilAcesso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}