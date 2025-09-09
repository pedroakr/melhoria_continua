package com.cottonstar.melhorias.model;
import com.cottonstar.melhorias.model.enums.StatusEtapa;

import java.time.LocalDate;

public class Plano {
    private String id;
    private String analiseProblema;     // Breve identificação do Problema
    private String estrategia;          // Breve resumo do pretende-se fazer
    private String objetivos;           // Breve descrição do objetivo da melhoria
    private LocalDate prazoPrevisto;    // Previsão de finalização
    private Usuario responsavel;        // Usuario que comandará o processo de melhoria

    private String participantesPlano;           // Receberá os valores e agrupará por ; para armazenar no DB

    private StatusEtapa StatusPlano;
}