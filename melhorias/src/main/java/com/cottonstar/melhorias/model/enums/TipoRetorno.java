package com.cottonstar.melhorias.model.enums;

public enum TipoRetorno {
    PRODUTIVIDADE("Produtividade"),
    FINANCEIRO("Financeiro"),
    QUALIDADE("Qualidade"),
    EFICIENCIA("Eficiência"),
    OPERACIONAL("Operacional"),
    ESTRATEGICO("Estratégico"),
    SATISFACAO_CLIENTE("Satisfação do Cliente"),
    INOVACAO("Inovação"),
    RISCO("Risco"),
    ENGAJAMENTO("Engajamento"),
    SUSTENTABILIDADE("Sustentabilidade");

    private final String descricao;

    TipoRetorno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}