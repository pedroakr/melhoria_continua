package com.cottonstar.melhorias.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_comentarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String mensagem;

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "melhoria_fk")
    private MelhoriaModel melhoria;

    @ManyToOne
    @JoinColumn(name = "execucao_fk")
    private ExecucaoModel execucao;

    // DATA (REVISAR NO DESENVOLVIMENTO DE REGRAS)
    @Column(name = "data_comentario", nullable = false, updatable = false)
    private LocalDateTime dataComentario;

    @PrePersist
    protected void onCreate() {
        this.dataComentario = LocalDateTime.now();     // GERADO DE FORMA AUTOMATICA
    }
}