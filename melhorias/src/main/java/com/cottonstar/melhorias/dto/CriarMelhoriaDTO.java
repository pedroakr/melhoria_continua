package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.TamanhoMelhoria;
import com.cottonstar.melhorias.model.enums.TipoRetorno;
import lombok.Getter;

@Getter
public class CriarMelhoriaDTO {
    private String titulo;
    private TamanhoMelhoria tipo;
    private Departamento departamentoMelhoria;
    private TipoRetorno tipoRetorno;
    private String descricao;
}