package com.cottonstar.melhorias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_certificados")
@Getter
@Setter
public class CertificadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "melhoria_fk", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private MelhoriaModel melhoria;

    @ManyToMany
    @JoinTable(
            name = "tb_certificados_usuarios",
            joinColumns = @JoinColumn(name = "certificado_fk"),
            inverseJoinColumns = @JoinColumn(name = "usuario_fk")
    )

    private Set<UsuarioModel> usuarios = new HashSet<>();

    // DATAS --(VERIFICAR NO DESENVOLVIMENTO DE REGRAS)
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDate dataCertificado;

    @PrePersist
    protected void onCreate() {
        this.dataCertificado = LocalDate.now();     // GERADO DE FORMA AUTOMATICA
    }
}