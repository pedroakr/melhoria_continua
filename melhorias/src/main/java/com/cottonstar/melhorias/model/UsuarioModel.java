package com.cottonstar.melhorias.model;

//import com.cottonstar.melhorias.model.enums.Departamento;
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
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "email", nullable = false, length = 30, unique = true)
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
    private List<MelhoriaModel> melhoriasResponsavel;   // MELHORIAS QUE O USUARIO TEM CADASTRADO

    @OneToMany(mappedBy = "gestor")
    private List<MelhoriaModel> melhoriasGestor;   // MELHORIAS QUE O GESTOR TEM DA EQUIPE
}