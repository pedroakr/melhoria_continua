package com.cottonstar.melhorias.model;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String departamento;
    private String cargo;
    private String senhaHash; // nunca guardar senha pura!

    // Permissões de acesso: ADMIN, GESTOR, COLABORADOR
    private PerfilAcesso perfil;

    // Getters, Setters, Construtores
}