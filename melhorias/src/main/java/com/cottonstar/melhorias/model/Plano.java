package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_plano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "analise", columnDefinition = "TEXT")
    private String analiseProblema;                     // DESCRIÇÃO DO PROBLEMA

    @Column(name = "estrategia", columnDefinition = "TEXT")
    private String estrategia;                          // O QUE SERÁ FEITO

    @Column(name = "objetivos", columnDefinition = "TEXT")
    private String objetivos;                           // RESULTADO ESPERADO

    @Column(name = "valor_expectativa", precision = 15, scale = 2)
    private BigDecimal expectativaFinanceira = BigDecimal.ZERO;                     // RETORNO FINANCEIRO ESPERADO R$   { IF TipoRetorno == "FINANCEIRO" }

    @Column(name = "tempo_expectativa", precision = 4, scale = 2)                   // RETORNO ESPERADO DE PRODUTIVIDADE
    private BigDecimal expectativaTempo;

    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipacaoPlano> participantesPlano = new ArrayList<>();          // USUARIOS QUE PARTICIPARÃO

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusEtapa statusPlano;                    // STATUS ATUAL { AO CRIAR MELHORIA (AÇÃO) STARTAR COMO "INICIADO", APÓS O USUARIO PODE ALTERAR PARA FINALIZADO QUANDO ACHAR NECESSARIO

    @OneToOne(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Melhoria melhoria;

    // DATAS --(VERIFICAR NO DESENVOLVIMENTO DAS REGRAS)
    @Column(name = "data_inicio", nullable = false, updatable = false)
    private LocalDate inicioPlano;                      // DATA INICIDA (GERADO AO STARTAR) { IF statusPlano == "INICIADO" }

    @PrePersist
    protected void onCreate() {
        this.inicioPlano = LocalDate.now();             // GERADO DE FORMA AUTOMATICA
    }
    @Column(name = "data_fim", nullable = true, updatable = false)
    private LocalDate fimPlano;                         // DATA FINAL (GERADO AO FINALIZAR) { IF statusPlano == "FINALIZADO" }
}