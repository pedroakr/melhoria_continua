package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_participantes_execucao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipacaoExecucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "execucao_id", nullable = false)
    private Execucao execucao;
}