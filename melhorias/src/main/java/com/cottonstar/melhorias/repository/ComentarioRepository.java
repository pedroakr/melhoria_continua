package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, String> {
}