package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_participantes_plano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipacaoPlanoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private UsuarioModel usuarioId;
    private PlanoModel planoId;
}
