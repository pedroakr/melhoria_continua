package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
import com.cottonstar.melhorias.model.enums.TamanhoMelhoria;
import com.cottonstar.melhorias.model.enums.TipoRetorno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

// Tranforma classe em entidade no DB
@Entity
@Table(name = "tb_melhorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MelhoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String titulo;

    // CLASSES
    @ManyToOne
    @JoinColumn(name = "responsavel_fk", nullable = false)
    private UsuarioModel responsavel;               // QUEM CADASTROU -> Pega automatico pelo login

    @ManyToOne
    @JoinColumn(name = "gestor_fk")
    private UsuarioModel gestor;                    // QUEM APROVA/ACOMPANHA

    @OneToOne(mappedBy = "melhoria", cascade = CascadeType.ALL)
    private CertificadoModel certificado;

    // PDCL
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plano_fk", nullable = true ,referencedColumnName = "id")
    private PlanoModel plano;                            // IDENTIFICACAO E PLANEJAMENTO

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "execucao_fk", nullable = true, referencedColumnName = "id")
    private ExecucaoModel execucao;                      // ACOMPANHAMENTO

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verificacao_fk", nullable = true, referencedColumnName = "id")
    private VerificacaoModel verificacao;                // RESULTADOS

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aprendizado_fk", nullable = true, referencedColumnName = "id")
    private AprendizadoModel aprendizado;                // APRENDIZADO

    // COMENTARIOS
    @OneToMany(mappedBy = "melhoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComentarioModel> comentariosMelhoria;

    // ENUMS
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TamanhoMelhoria tamanhoMelhoria;        // PEQUENA, MEDIA, GRANDE

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoRetorno tipoRetorno;                // FINANCEIRO, QUALIDADE, PRODUTIVIDADE

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Departamento departamentoMelhoria;      // DEPARTAMENTO ONDE SERA IMPLANTADA

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusMelhoria status;                  // CRIADO, EM_ANDAMENTO, APROVADO, CONCLUIDO, REJEITADO

    // DATAS --(REVISAR QUANDO DESENVOVER O .JS)
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDate dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDate.now();     // GERADO DE FORMA AUTOMATICA
    }

    private LocalDate dataConclusao;            // GERADO DE FORMA AUTOMATICA
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