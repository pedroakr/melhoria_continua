package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.ParticipacaoExecucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ParticipacaoExecucaoRepository extends JpaRepository<ParticipacaoExecucao, Long> {
}