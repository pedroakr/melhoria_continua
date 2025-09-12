package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.StatusEtapa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_aprendizado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aprendizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String descricaoAprendizado;                        // DESCRIÇÃO DO QUE FOI APRENDIDO

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusEtapa statusAprendizado;                      // STATUS ATUAL { IF statusVerificacao == "AGUARDANDO" { statusAprendizado = "AGUARDANDO"  } IF statusVerificacao == "FINALIZADO" { statusAprendizado = "INICIADO" } IF PRESS_BOTAO_FINALIZAR = TRUE { statusAprendizado = "FINALIZADO" } }

    @OneToOne(mappedBy = "aprendizado", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Melhoria melhoria;

    // DATAS --(VERIFICAR NO DESENVOLVIMENTO DO .JS)
    @Column(name = "data_inicio", nullable = false, updatable = false)
    private LocalDate inicioAprendizado;                        // DATA INICIAL            { IF statusAprendizado == "INICIADO" { inicioAprendizado = DATA ATUAL } }

    @PrePersist
    protected void onCreate() {
        this.inicioAprendizado = LocalDate.now();
    }

    private LocalDate fimAprendizado;                           // DATA QUE FOI FINALIZADO { IF statusAprendizado == "FINALIZADO" { fimAprendizado = DATA ATUAL } }
}