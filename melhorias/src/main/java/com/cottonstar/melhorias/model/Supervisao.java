package com.cottonstar.melhorias.model;

import com.cottonstar.melhorias.model.enums.Departamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_supervisao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supervisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 60)
    private String nomeSupervisor;

    @Column(name = "email_supervisor", nullable = false, length = 60)
    private String emailSupervisor;

    @Enumerated(EnumType.STRING)
    @Column(name = "departamento", nullable = false, unique = true)
    private Departamento departamento;

    @OneToMany(mappedBy = "supervisor")
    @JsonIgnore
    private List<Usuario> usuariosSupervisionados;
}