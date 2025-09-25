package com.cottonstar.melhorias.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // Nome original do arquivo enviado pelo usuário (ex: "relatorio.pdf")
    @Column(name = "nome_original")
    private String nomeOriginal;

    // Nome único do arquivo salvo no servidor (ex: "uuid-relatorio.pdf")
    @Column(name = "nome_armazenado")
    private String nomeArmazenado;

    // Tipo de conteúdo (MIME type, ex: "application/pdf")
    @Column(name = "content_type")
    private String contentType;

    // Tamanho do arquivo em bytes
    @Column(name = "tamanho")
    private Long tamanho;

    @Column(name = "data_upload", updatable = false)
    private LocalDateTime dataUpload;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "execucao_fk")
    @JsonBackReference // <-- Essencial para quebrar o loop
    private Execucao execucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verificacao_fk")
    @JsonBackReference // <-- Adicionado para consistência
    private Verificacao verificacao;

    @PrePersist
    protected void onUpload() {
        this.dataUpload = LocalDateTime.now();
    }
}