package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.ExecucaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecucaoRepository extends JpaRepository<ExecucaoModel, String> {
}