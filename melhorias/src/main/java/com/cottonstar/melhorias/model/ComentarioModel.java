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
    private String mensagem;
    private LocalDateTime dataComentario;       // GERADO AUTOMATICAMENTE

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "melhoria_fk")
    private MelhoriaModel melhoriaFk;

    @ManyToOne
    @JoinColumn(name = "execucao_fk")
    private ExecucaoModel execucaoFk;
}