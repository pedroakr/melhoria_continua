package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.PerfilAcesso;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 60)
    private String nome;

    @Column(name = "usuario", length = 40)
    private String usuario;

    @Column(name = "email", length = 60, unique = true)
    private String email;

    @Column(name = "senha_hash")
    private String senhaHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_fk")
    private Supervisao supervisor;

    // Permissões de acesso: ADMIN, GESTOR, COLABORADOR
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", length = 20)
    private PerfilAcesso perfil;

    @Enumerated(EnumType.STRING)
    @Column(name = "departamento")
    private Departamento departamento;

    // PARA LISTAR AS MELHORIAS NO FRONT
    @OneToMany(mappedBy = "responsavel")
    private List<Melhoria> melhoriasResponsavel;                // MELHORIAS QUE O USUARIO TEM CADASTRADO

    @OneToMany(mappedBy = "usuario")
    private List<ParticipacaoPlano> participacoesPlano;         // PARTICIPAÇÕES DO USUÁRIO NOS PLANOS DE AÇÃO

    @OneToMany(mappedBy = "usuario")
    private List<ParticipacaoExecucao> participacoesExecucao;   // PARTICIPAÇÕES DO USUÁRIO NAS EXECUÇÕES

}