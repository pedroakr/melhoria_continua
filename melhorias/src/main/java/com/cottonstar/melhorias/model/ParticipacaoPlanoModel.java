package com.cottonstar.melhorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoPlanoModel {
    private String id;
    private UsuarioModel usuarioId;
    private PlanoModel planoId;
}
