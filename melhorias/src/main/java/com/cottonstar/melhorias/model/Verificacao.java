package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_verificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Verificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "indicadores_analisados", columnDefinition = "TEXT",  nullable = false)
    private String indicadoresAnalisados;

    @Column(name = "resultados_obtidos", columnDefinition = "TEXT",  nullable = false)
    private String resultadosObtidos;

    @Column(name = "valor_retornado", precision = 15, scale = 2)
    private BigDecimal valorRetornado = BigDecimal.ZERO;

    @Column(name = "tempo_retornado", precision = 4, scale = 2)                   // RETORNO ESPERADO DE PRODUTIVIDADE
    private BigDecimal tempoRetornado;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private StatusEtapa statusVerificacao;  // STATUS { IF statusExecucao == "INICIADO" { statusVerificacao = "AGUARDANDO" } IF statusExecucao == "FINALIZADO" { statusVerificacao = "INICIADO" } IF PRESIONADO_BOTAO_FINALIZAR == TRUE { statusVerificacao = "FINALIZADO" }}

    @OneToOne(mappedBy = "verificacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Melhoria melhoria;

    @OneToMany(mappedBy = "verificacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Arquivo> anexosVerificacao = new ArrayList<>();

    // DATAS --(VERIFICAR NO DESENVOLVIMENTO DE REGRAS)
    @Column(name = "data_inicio", nullable = false, updatable = false)
    private LocalDate inicioVerificacao;

    @PrePersist
    protected void onCreate() {
        this.inicioVerificacao = LocalDate.now();
    }

    @Column(name = "data_fim", nullable = true, updatable = false)
    private LocalDate fimVerificacao;             // Data final gerada automaticamente ao alterar StatusEtapa para "Finalizado"
}