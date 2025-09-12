package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Execucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecucaoRepository extends JpaRepository<Execucao, String> {
}