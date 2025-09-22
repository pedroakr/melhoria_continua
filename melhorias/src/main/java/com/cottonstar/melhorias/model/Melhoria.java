package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.*;
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

    @Column(columnDefinition = "TEXT")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    // --- RELACIONAMENTOS ---
    //@ToString.Exclude
    //@OneToMany(mappedBy = "melhoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //private List<Comentario> comentariosMelhoria;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_fk")
    private Usuario responsavel;

    @ToString.Exclude
    @OneToOne(mappedBy = "melhoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Certificado certificado;

    // PDCL
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "plano_fk", referencedColumnName = "id")
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

    // --- ENUMS E DADOS ---
    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho", length = 20)
    private TamanhoMelhoria tamanhoMelhoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "retorno", length = 20)
    private TipoRetorno tipoRetorno;

    @Enumerated(EnumType.STRING)
    @Column(name = "departamento", length = 20)
    private Departamento departamentoMelhoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private StatusEtapa status;

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
        if (this.status == StatusEtapa.FINALIZADO && this.dataConclusao == null) {
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