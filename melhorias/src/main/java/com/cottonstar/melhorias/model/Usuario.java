package com.cottonstar.melhorias.model;

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

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "usuario", nullable = false, length = 40)
    private String usuario;

    @Column(name = "email", nullable = false, length = 60, unique = true)
    private String email;

    //@Column(name = "departamento", length = 30)       É ENUM - CUIDAR
    //private Departamento departamento;

    @Column(name = "senha_hash", nullable = false)
    private String senhaHash;

    // Permissões de acesso: ADMIN, GESTOR, COLABORADOR
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false, length = 20)
    private PerfilAcesso perfil;

    // PARA LISTAR AS MELHORIAS NO FRONT
    @OneToMany(mappedBy = "responsavel")
    private List<Melhoria> melhoriasResponsavel;                // MELHORIAS QUE O USUARIO TEM CADASTRADO

    @OneToMany(mappedBy = "gestor")
    private List<Melhoria> melhoriasGestor;                     // MELHORIAS QUE O GESTOR TEM DA EQUIPE

    @OneToMany(mappedBy = "usuario")
    private List<ParticipacaoPlano> participacoesPlano;         // PARTICIPAÇÕES DO USUÁRIO NOS PLANOS DE AÇÃO

    @OneToMany(mappedBy = "usuario")
    private List<ParticipacaoExecucao> participacoesExecucao;   // PARTICIPAÇÕES DO USUÁRIO NAS EXECUÇÕES

}