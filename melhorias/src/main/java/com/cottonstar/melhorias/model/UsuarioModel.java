package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private Departamento departamento;      // departamento do usuario
    private String senhaHash;               // nunca guardar senha pura

    // Permissões de acesso: ADMIN, GESTOR, COLABORADOR
    private PerfilAcesso perfil;
}