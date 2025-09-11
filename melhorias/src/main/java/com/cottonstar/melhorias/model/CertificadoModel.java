package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_certificados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Verificar
    @ManyToOne
    @JoinColumn(name = "melhoria_id", nullable = false)
    private MelhoriaModel melhoria;

    private String caminhoArquivo;                          // onde foi salvo o PDF

    private LocalDateTime dataGeracao;
}

