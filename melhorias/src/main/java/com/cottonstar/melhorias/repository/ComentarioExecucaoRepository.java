package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.ComentarioExecucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioExecucaoRepository extends JpaRepository<ComentarioExecucao, Long> {
}