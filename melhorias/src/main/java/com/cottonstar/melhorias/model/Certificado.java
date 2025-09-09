package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "melhoria_id", nullable = false)
    private Melhoria melhoria;

    private String caminhoArquivo; // onde foi salvo o PDF

    private LocalDateTime dataGeracao;
}

