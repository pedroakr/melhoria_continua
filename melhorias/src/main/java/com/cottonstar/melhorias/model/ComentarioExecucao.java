package com.cottonstar.melhorias.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_comentarios_execucao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioExecucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensagem", columnDefinition = "TEXT")
    private String mensagem;

    // --- RELACIONAMENTOS ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "execucao_fk")
    @JsonBackReference                                                      // Evita loops infinitos ao retornar JSON
    private Execucao execucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_fk")
    private Usuario autor;

    // --- DATA ---
    @Column(name = "data_comentario", updatable = false)
    private LocalDateTime dataComentario;

    @Column(name = "data_edicao")
    private LocalDateTime dataEdicao;

    @PrePersist
    protected void onCreate() {
        this.dataComentario = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataEdicao = LocalDateTime.now();
    }
}