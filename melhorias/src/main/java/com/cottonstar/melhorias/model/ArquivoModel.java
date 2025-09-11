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
public class ArquivoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Caminho ou URL no sistema externo
    @Column(name = "caminho_arquivo", nullable = false, length = 500)
    private String caminhoArquivo;

    @Column(name = "data_upload", nullable = false, updatable = false)
    private LocalDateTime dataUpload;

    @PrePersist
    protected void onUpload() {
        this.dataUpload = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "execucao_fk", nullable = false)
    private ExecucaoModel execucao;

    @ManyToOne
    @JoinColumn(name = "verificacao_fk", nullable = false)
    private VerificacaoModel verificacao;
}