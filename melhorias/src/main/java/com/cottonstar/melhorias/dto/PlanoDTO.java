package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Plano;
import com.cottonstar.melhorias.model.enums.StatusEtapa;

import java.time.LocalDate;

public class PlanoDTO {
    private Long id;
    private String analiseProblema;
    private String estrategia;
    private String objetivos;
    private LocalDate prazoPrevisto;
    private String responsavelNome;
    private String participantesPlano;
    private StatusEtapa statusPlano;

    public PlanoDTO(Plano plano) {
        this.id = plano.getId();
        this.analiseProblema = plano.getAnaliseProblema();
        this.estrategia = plano.getEstrategia();
        this.objetivos = plano.getObjetivos();
        this.statusPlano = plano.getStatusPlano();
    }
}