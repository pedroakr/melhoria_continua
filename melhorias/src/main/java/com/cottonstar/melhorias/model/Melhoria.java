package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
//import java.util.List;

@Entity
@Table(name = "tb_melhorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Melhoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_fk")
    private Usuario responsavel;

    @Column(columnDefinition = "TEXT")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    // --- ENUMS E DADOS ---
    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho")
    private TamanhoMelhoria tamanhoMelhoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "retorno")
    private TipoRetorno tipoRetorno;

    @Enumerated(EnumType.STRING)
    @Column(name = "departamento")
    private Departamento departamentoMelhoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusMelhoria status;

    // PDCL
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "plano_fk", referencedColumnName = "id")
    @JsonManagedReference
    private Plano plano;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "execucao_fk", referencedColumnName = "id")
    private Execucao execucao;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "verificacao_fk", referencedColumnName = "id")
    private Verificacao verificacao;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "aprendizado_fk", referencedColumnName = "id")
    private Aprendizado aprendizado;

    // CERTIFICADO
    @ToString.Exclude
    @OneToOne(mappedBy = "melhoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Certificado certificado;

    // --- AUDITORIA ---
    @Column(name = "data_criacao", updatable = false)
    private LocalDate dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDate.now();     // GERADO DE FORMA AUTOMATICA
    }

    @Column(name = "data_fim")
    private LocalDate dataConclusao;            // GERADO DE FORMA AUTOMATICA

    @PreUpdate
    protected void onUpdate() {
        if (this.status == StatusMelhoria.CONCLUIDO && this.dataConclusao == null) {
            this.dataConclusao = LocalDate.now();
        }
    }
}


/* IF (BOTAO_CRIAR_MELHORIA_PRESSIONADO = TRUE) {
    INPUT   titulo
    SELECT  tamanhoMelhoria
    SELECT  tipoRetorno
    SELECT  departamentoMelhoria
    INPUT   responsavel = USUARIO_LOGADO

    IF (tamanhoMelhoria == "PEQUENA" OR "MEDIA"{
        planoModel = INICIADO
        execucaoModel = AGUARDANDO
        verificacaoModel = AGUARDANDO
        aprendizadoModel = AGUARDANDO

        status = EM_ANDAMENTO
    }

    IF (tamanhoMelhoria == "GRANDE"{
        status = EM_ANDAMENTO
    }
}


 */