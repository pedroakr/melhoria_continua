package com.cottonstar.melhorias.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponseDTO {
    private String token;

    public AuthResponseDTO(String jwt) {
        this.token = jwt;
    }
}
