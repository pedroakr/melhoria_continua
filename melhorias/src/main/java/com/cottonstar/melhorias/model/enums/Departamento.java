package com.cottonstar.melhorias.model.enums;

import lombok.Getter;

@Getter
public enum Departamento {
    ACABAMENTO("Acabamento"),
    ALMOXARIFADO("Almoxarifado"),
    AMOSTRA("Amostra"),
    AUDITORIA("Auditoria"),
    CD("CD"),
    COMERCIAL("Comercial"),
    COMPRAS("Compras"),
    CONFORMIDADE("Conformidade"),
    CONTROLADORIA("Controladoria"),
    CORTE("Corte"),
    COSTURA("Costura"),
    DESCARACTERIZACAO("Descaracterizacao"),
    DESENVOLVIMENTO("Desenvolvimento"),
    DIRETORIA("Diretoria"),
    DM_CRUA("DM Crua"),
    DM_TINTA("DM Tinta"),
    ENGENHARIA("Engenharia"),
    EXPEDICAO("Expedicao"),
    FACILITIES("Facilities"),
    FECHAMENTO("Fechamento"),
    GERENCIA("Gerencia"),
    GERENTE_TERRA_BOA("Gerente Terra Boa"),
    LABORATORIO("Laboratorio"),
    LOGISTICA("Logistica"),
    LUNARA("Lunara"),
    LUNARA_COMERCIAL("Lunara Comercial"),
    LUNARA_DESENVOLVIMENTO("Lunara Desenvolvimento"),
    LUNARA_EXPEDICAO("Lunara Expedicao"),
    LUNARA_PCP("Lunara PCP"),
    LUNARA_PPCP("Lunara PPCP"),
    LUNARA_PRODUCAO("Lunara Producao"),
    MODELAGEM("Modelagem"),
    PLANEJAMENTO("Planejamento"),
    PPCP_CONFECCAO("PPCP Confeccao"),
    PPCP_TEXTIL("PPCP Textil"),
    PRODUCAO("Producao"),
    QUALIDADE("Qualidade"),
    QUALIDADE_INTERNA("Qualidade Interna"),
    RECEBIMENTO("Recebimento"),
    RH("RH"),
    SEM_SETOR("Sem Setor"),
    SGQ("SGQ"),
    SOURCING("Sourcing"),
    TERRA_BOA_EXPEDICAO("Terra Boa Expedicao"),
    TERRA_BOA_PRODUCAO("Terra Boa Producao"),
    TERRA_BOA_RH("Terra Boa RH"),
    TI("TI");

    private final String descricao;

    Departamento(String descricao) {
        this.descricao = descricao;
    }
}