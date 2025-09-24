package com.cottonstar.melhorias.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_comentarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menssagem", columnDefinition = "TEXT")
    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "execucao_fk")
    @JsonBackReference // Evita loops infinitos ao retornar JSON
    private Execucao execucao;

    // DATA (REVISAR NO DESENVOLVIMENTO DE REGRAS)
    @Column(name = "data_comentario", updatable = false)
    private LocalDateTime dataComentario;

    @PrePersist
    protected void onCreate() {
        this.dataComentario = LocalDateTime.now();
    }
}