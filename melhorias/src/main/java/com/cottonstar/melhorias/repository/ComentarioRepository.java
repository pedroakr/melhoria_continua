package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}