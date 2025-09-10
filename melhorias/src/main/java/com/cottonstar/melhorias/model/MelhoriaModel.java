package com.cottonstar.melhorias.model;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
import com.cottonstar.melhorias.model.enums.TipoMelhoria;
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
    private TipoMelhoria tipo;
    private Departamento departamentoMelhoria;      // departamento onde será criada a melhoria
    private StatusMelhoria status;                  // Aparece após cadastro

    // Classe
    private UsuarioModel responsavel;                    // quem cadastrou -> Pega automatico pelo login
    private UsuarioModel gestor;                         // quem aprova/acompanha

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    // Cada melhoria segue o PDCL
    private PlanoModel planoModel;                            // Identificação e Planejamento
    private ExecucaoModel execucaoModel;                      // Acompanhamento do que está sendo feito
    private VerificacaoModel verificacaoModel;                // Resultados obtidos
    private AprendizadoModel aprendizadoModel;                // Aprendizado do que foi realizado

    private ComentarioModel comentarioModels;           // histórico de interação
}