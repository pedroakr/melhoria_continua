package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_execucao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Execucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipacaoExecucao> participantesExecucao = new ArrayList<>();

    @OneToMany(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentariosExecucao;

    // Lista de anexos
    @OneToMany(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Arquivo> anexosExecucao = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private StatusEtapa statusExecucao;                                 // STATUS { IF statusPlano == "INICIADO" { statusExecucao = "AGUARDANDO" } IF statusPlano == "FINALIZADO" { statusExecucao = "INICIADO" } IF PRESIONADO_BOTAO_FINALIZAR == TRUE { statusExecucao = "FINALIZADO" } }

    @OneToOne(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Melhoria melhoria;

    // DATAS --(VERIFICAR NO DESENVOLVIMENTO DAS REGRAS)
    @Column(name = "data_inicio", nullable = false, updatable = false)
    private LocalDate inicioExecucao;

    @PrePersist
    protected void onCreate() {
        this.inicioExecucao = LocalDate.now();     // GERADO DE FORMA AUTOMATICA
    }

    @Column(name = "data_fim", nullable = false, updatable = false)
    private LocalDate fimExecucao;
}