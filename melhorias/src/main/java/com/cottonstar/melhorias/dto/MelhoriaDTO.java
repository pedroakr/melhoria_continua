package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
import com.cottonstar.melhorias.model.enums.TipoMelhoria;

import java.time.LocalDateTime;

public class MelhoriaDTO {
    private String id;
    private String titulo;
    private TipoMelhoria tipo;
    private Departamento departamentoMelhoria;
    private String responsavelNome;
    private String gestorNome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private StatusMelhoria status;
}