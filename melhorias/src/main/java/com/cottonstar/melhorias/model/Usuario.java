package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private Departamento departamento;      // departamento do usuario
    private String cargo;
    private String senhaHash;               // nunca guardar senha pura

    // Permissões de acesso: ADMIN, GESTOR, COLABORADOR
    private PerfilAcesso perfil;

    // Getters, Setters, Construtores
}