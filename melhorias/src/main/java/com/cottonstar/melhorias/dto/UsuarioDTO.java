package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;

public class UsuarioDTO {
    private String id;
    private String nome;
    private String email;
    private Departamento departamento;
    private String cargo;
    private PerfilAcesso perfil;
}