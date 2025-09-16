package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_participantes_plano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipacaoPlano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;
}