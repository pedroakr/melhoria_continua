package com.cottonstar.melhorias.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "execucao_fk")
    @JsonBackReference
    private Execucao execucao;
}