package com.cottonstar.melhorias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_participantes_execucao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipacaoExecucaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private UsuarioModel usuarioId;
    private ExecucaoModel execucaoId;
}