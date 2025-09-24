package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.ParticipacaoExecucao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParticipacaoExecucaoDTO {

    private Long id; // ID da participação
    private Long usuarioId;
    private String usuarioNome;

    public ParticipacaoExecucaoDTO(ParticipacaoExecucao participacao) {
        this.id = participacao.getId();
        if (participacao.getUsuario() != null) {
            this.usuarioId = participacao.getUsuario().getId();
            this.usuarioNome = participacao.getUsuario().getNome();
        }
    }
}