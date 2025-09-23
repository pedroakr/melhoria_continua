package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlanoUpdateDTO {

    private String analiseProblema;
    private String estrategia;
    private String objetivos;
    private BigDecimal expectativaFinanceira;
    private BigDecimal expectativaTempo;
    private StatusEtapa statusPlano;
}