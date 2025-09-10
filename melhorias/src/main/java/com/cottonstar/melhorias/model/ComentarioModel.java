package com.cottonstar.melhorias.model;

import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioModel {
    private String id;
    private String mensagem;
    private LocalDateTime dataComentario;
}