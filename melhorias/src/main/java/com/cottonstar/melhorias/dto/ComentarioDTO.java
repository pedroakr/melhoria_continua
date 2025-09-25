package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.ComentarioExecucao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ComentarioDTO {

    private Long id;
    private String mensagem;
    private String autorNome;
    private Long autorId;
    private LocalDateTime dataComentario;
    private LocalDateTime dataEdicao; // Informa ao front-end se o comentário foi editado
    private boolean editado;

    public ComentarioDTO(ComentarioExecucao comentario) {
        this.id = comentario.getId();
        this.mensagem = comentario.getMensagem();
        this.dataComentario = comentario.getDataComentario();
        this.dataEdicao = comentario.getDataEdicao();
        this.editado = comentario.getDataEdicao() != null; // Simples flag para o front-end

        if (comentario.getAutor() != null) {
            this.autorNome = comentario.getAutor().getNome();
            this.autorId = comentario.getAutor().getId();
        }
    }
}
