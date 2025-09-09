package com.cottonstar.melhorias.model;
import java.time.LocalDateTime;
import java.util.List; // Verificar

// POJO -> Plain Old Java Object
public class Melhoria {

    private String id;
    private String titulo;

    //Outras Classes
    private StatusMelhoria status;
    private Usuario responsavel;                // quem cadastrou
    private Usuario gestor;                     // quem aprova/acompanha
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    // Cada melhoria segue o PDCL
    private Plano plano;                // Identificação e Planejamento
    private Execucao execucao;          // Acompanhamento do que está sendo feito
    private Verificacao verificacao;    // Resultados obtidos
    private Aprendizado aprendizado;    // Aprendizado do que foi realizado

    private List<Comentario> comentarios; // histórico de interação

    // Getters, Setters, Construtores
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public StatusMelhoria getStatus() {
        return status;
    }

    public void setStatus(StatusMelhoria status) {
        this.status = status;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Usuario getGestor() {
        return gestor;
    }

    public void setGestor(Usuario gestor) {
        this.gestor = gestor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Execucao getExecucao() {
        return execucao;
    }

    public void setExecucao(Execucao execucao) {
        this.execucao = execucao;
    }

    public Verificacao getVerificacao() {
        return verificacao;
    }

    public void setVerificacao(Verificacao verificacao) {
        this.verificacao = verificacao;
    }

    public Aprendizado getAprendizado() {
        return aprendizado;
    }

    public void setAprendizado(Aprendizado aprendizado) {
        this.aprendizado = aprendizado;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Melhoria{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", status=" + status +
                ", responsavel=" + responsavel +
                ", gestor=" + gestor +
                ", dataCriacao=" + dataCriacao +
                ", dataConclusao=" + dataConclusao +
                ", plano=" + plano +
                ", execucao=" + execucao +
                ", verificacao=" + verificacao +
                ", aprendizado=" + aprendizado +
                ", comentarios=" + comentarios +
                '}';
    }
}