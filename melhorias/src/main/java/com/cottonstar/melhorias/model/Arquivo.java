package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_arquivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Caminho ou URL no sistema externo
    @Column(name = "caminho", length = 500)
    private String caminhoArquivo;

    @Column(name = "data", updatable = false)
    private LocalDateTime dataUpload;

    @PrePersist
    protected void onUpload() {
        this.dataUpload = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "execucao_fk", nullable = true)
    private Execucao execucao;

    @ManyToOne
    @JoinColumn(name = "verificacao_fk", nullable = true)
    private Verificacao verificacao;
}