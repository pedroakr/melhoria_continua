package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Melhoria; // Importe a entidade
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.cottonstar.melhorias.model.enums.TamanhoMelhoria;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MelhoriaDTO {
    private Long id;
    private String titulo;
    private TamanhoMelhoria tamanhoMelhoria;
    private Departamento departamentoMelhoria;
    private String responsavelNome;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao; // Pode ser nulo
    private StatusEtapa status;

    // Construtor que converte a Entidade para DTO
    public MelhoriaDTO(Melhoria melhoria) {
        this.id = melhoria.getId();
        this.titulo = melhoria.getTitulo();
        this.tamanhoMelhoria = melhoria.getTamanhoMelhoria();
        this.departamentoMelhoria = melhoria.getDepartamentoMelhoria();
        this.status = melhoria.getStatus();
        this.dataCriacao = melhoria.getDataCriacao();
        this.dataConclusao = melhoria.getDataConclusao();

        // Evita NullPointerException e acessos desnecessários
        if (melhoria.getResponsavel() != null) {
            this.responsavelNome = melhoria.getResponsavel().getNome();
        }
    }
}