package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioModel {
    private String id;
    private String nome;
    private String email;
    private Departamento departamento;      // departamento do usuario
    private String senhaHash;               // nunca guardar senha pura

    // Permissões de acesso: ADMIN, GESTOR, COLABORADOR
    private PerfilAcesso perfil;
}