package com.cottonstar.melhorias.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioCreateDTO {

    @NotBlank(message = "A mensagem do comentário não pode ser vazia.")
    private String mensagem;
}
