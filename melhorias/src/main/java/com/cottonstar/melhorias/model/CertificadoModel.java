package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "melhoria_id", nullable = false)
    private MelhoriaModel melhoria;

    private String caminhoArquivo; // onde foi salvo o PDF

    private LocalDateTime dataGeracao;
}

