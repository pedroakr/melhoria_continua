package com.cottonstar.melhorias.dto;

import com.cottonstar.melhorias.model.Plano;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PlanoDTO {
    private Long id;
    private String analiseProblema;
    private String estrategia;
    private String objetivos;
    private LocalDate prazoPrevisto;
    private String responsavelNome;
    private StatusEtapa statusPlano;

    // <-- CORREÇÃO: Construtor preenchido com a lógica de mapeamento.
    public PlanoDTO(Plano plano) {
        this.id = plano.getId();
        this.analiseProblema = plano.getAnaliseProblema();
        this.estrategia = plano.getEstrategia();
        this.objetivos = plano.getObjetivos();
        this.statusPlano = plano.getStatusPlano();

        // Lógica segura para acessar dados de relacionamentos
        if (plano.getMelhoria() != null && plano.getMelhoria().getResponsavel() != null) {
            this.responsavelNome = plano.getMelhoria().getResponsavel().getNome();
        }

        // Lógica para o prazo previsto - ajuste conforme sua regra de negócio
        // Exemplo: usando a data de fim do plano.
        this.prazoPrevisto = plano.getFimPlano();
    }
}