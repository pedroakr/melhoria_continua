package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
import com.cottonstar.melhorias.model.enums.TamanhoMelhoria;

import java.time.LocalDateTime;

public class MelhoriaDTO {
    private Long id;
    private String titulo;
    private TamanhoMelhoria tipo;
    private Departamento departamentoMelhoria;
    private String responsavelNome;
    private String gestorNome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private StatusMelhoria status;
}