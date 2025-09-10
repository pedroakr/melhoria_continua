package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
    Optional<UsuarioModel> findByEmail(String email);
}