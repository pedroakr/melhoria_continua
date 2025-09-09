package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.StatusEtapa;

import java.time.LocalDate;

public class PlanoDTO {
    private String id;
    private String analiseProblema;
    private String estrategia;
    private String objetivos;
    private LocalDate prazoPrevisto;
    private String responsavelNome;
    private String participantesPlano;
    private StatusEtapa statusPlano;
}