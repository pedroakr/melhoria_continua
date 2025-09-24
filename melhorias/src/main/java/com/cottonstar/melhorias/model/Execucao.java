package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long id;

    // --- RELACIONAMENTOS ---
    @OneToMany(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference                                                                           // Lado "pai" da relação com ParticipacaoExecucao
    private List<ParticipacaoExecucao> participantesExecucao = new ArrayList<>();

    @OneToMany(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comentario> comentariosExecucao;

    @OneToMany(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Arquivo> anexosExecucao = new ArrayList<>();

    // --- ENUM ---
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEtapa statusExecucao;                                 // STATUS { IF statusPlano == "INICIADO" { statusExecucao = "AGUARDANDO" } IF statusPlano == "FINALIZADO" { statusExecucao = "INICIADO" } IF PRESIONADO_BOTAO_FINALIZAR == TRUE { statusExecucao = "FINALIZADO" } }

    @OneToOne(mappedBy = "execucao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Melhoria melhoria;

    // --- DATAS ---
    @Column(name = "data_inicio", updatable = false)
    private LocalDate inicioExecucao;

    @Column(name = "data_fim", nullable = true, updatable = false)
    private LocalDate fimExecucao;

    // --- MÉTODOS DE CICLO DE VIDA ---

    @PrePersist
    protected void onCreate() {
        if (this.inicioExecucao == null) {
            this.inicioExecucao = LocalDate.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        if (this.statusExecucao == StatusEtapa.FINALIZADO && this.fimExecucao == null) {
            this.fimExecucao = LocalDate.now();
        }
    }
}