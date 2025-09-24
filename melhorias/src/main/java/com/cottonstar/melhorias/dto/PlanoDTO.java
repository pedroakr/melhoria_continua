package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Plano;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PlanoDTO {
    private Long id;
    private String responsavelNome;
    private String analiseProblema;
    private String estrategia;
    private String objetivos;
    private BigDecimal expectativaFinanceira;
    private int expectativaTempo;
    private StatusEtapa statusPlano;

    public PlanoDTO(Plano plano) {
        this.id = plano.getId();
        this.analiseProblema = plano.getAnaliseProblema();
        this.estrategia = plano.getEstrategia();
        this.objetivos = plano.getObjetivos();
        this.expectativaFinanceira = plano.getExpectativaFinanceira();
        this.expectativaTempo = plano.getExpectativaTempo();
        this.statusPlano = plano.getStatusPlano();

        // Lógica segura para acessar dados de relacionamentos
        if (plano.getMelhoria() != null && plano.getMelhoria().getResponsavel() != null) {
            this.responsavelNome = plano.getMelhoria().getResponsavel().getNome();
        }
    }
}