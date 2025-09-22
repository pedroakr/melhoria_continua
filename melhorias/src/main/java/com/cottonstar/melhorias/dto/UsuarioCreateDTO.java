package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.Departamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreateDTO {

    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(max = 60, message = "O nome deve ter no máximo 60 caracteres.")
    private String nome;

    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "Formato de email inválido.")
    @Size(max = 60, message = "O email deve ter no máximo 60 caracteres.")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    private String senha;

    // --- CAMPO ADICIONADO ---
    @NotNull(message = "O departamento é obrigatório.")
    private Departamento departamento;
}