package com.cottonstar.melhorias.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdicionarParticipantesDTO {

    @NotEmpty(message = "A lista de IDs de usuários não pode ser vazia.")
    private List<Long> usuarioIds;
}
