package com.cottonstar.melhorias.model;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
import com.cottonstar.melhorias.model.enums.TipoMelhoria;

import java.time.LocalDateTime;
import java.util.List; // Verificar

// POJO -> Plain Old Java Object
public class Melhoria {

    private String id;
    private String titulo;

    // Enums
    private TipoMelhoria tipo;
    private Departamento departamentoMelhoria;      // departamento onde será criada a melhoria
    private StatusMelhoria status;                  // Aparece após cadastro

    // Classes
    private Usuario responsavel;                    // quem cadastrou -> Pega automatico pelo login
    private Usuario gestor;                         // quem aprova/acompanha
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    // Cada melhoria segue o PDCL
    private Plano plano;                            // Identificação e Planejamento
    private Execucao execucao;                      // Acompanhamento do que está sendo feito
    private Verificacao verificacao;                // Resultados obtidos
    private Aprendizado aprendizado;                // Aprendizado do que foi realizado

    private List<Comentario> comentarios;           // histórico de interação

    public void setId(String id) {

    }

    // Getters, Setters, Construtores
}