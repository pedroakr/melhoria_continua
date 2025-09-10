package com.cottonstar.melhorias.model.enums;

public enum TamanhoMelhoria {
    PEQUENA("Pequena"),        // Projetos simples                     -> SEM APROVAÇÃO  -  PONTUAÇÃO 3/LIDER 1/DEMAIS
    MEDIA("Média"),          // Projetos mais complexos              -> SEM APROVAÇÃO  -  PONTUAÇÃO 5/LIDER 2/DEMAIS
    GRANDE("Grande");          // Projetos de grande complexidade      -> COM APROVAÇÃO  -  PONTUAÇÃO 8/LIDER 3/DEMAIS

    private final String descricao;

    TamanhoMelhoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}