package com.cottonstar.melhorias.model;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
import com.cottonstar.melhorias.model.enums.TamanhoMelhoria;
import com.cottonstar.melhorias.model.enums.TipoRetorno;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MelhoriaModel {

    private String id;
    private String titulo;

    // Enums
    private TamanhoMelhoria tamanhoMelhoria;        // PEQUENA, MEDIA, GRANDE
    private TipoRetorno tipoRetorno;                // FINANCEIRO, QUALIDADE, PRODUTIVIDADE
    private Departamento departamentoMelhoria;      // DEPARTAMENTO ONDE SERA IMPLANTADA
    private StatusMelhoria status;                  // CRIADO, EM_ANDAMENTO, APROVADO, CONCLUIDO, REJEITADO

    // Classe
    private UsuarioModel responsavel;               // QUEM CADASTROU -> Pega automatico pelo login
    private UsuarioModel gestor;                    // QUEM APROVA/ACOMPANHA

    private LocalDateTime dataCriacao;              // GERADO DE FORMA AUTOMATICA
    private LocalDateTime dataConclusao;            // GERADO DE FORMA AUTOMATICA

    // Cada melhoria segue o PDCL
    private PlanoModel planoModel;                            // IDENTIFICACAO E PLANEJAMENTO
    private ExecucaoModel execucaoModel;                      // ACOMPANHAMENTO
    private VerificacaoModel verificacaoModel;                // RESULTADOS
    private AprendizadoModel aprendizadoModel;                // APRENDIZADO

    private ComentarioModel comentarioModels;                 // COMENTARIO / MENSSAGEM
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