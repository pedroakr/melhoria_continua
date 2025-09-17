package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MelhoriaRepository extends JpaRepository<Melhoria, Integer> {

    List<Melhoria> findByResponsavelId(Integer responsavelId);

    List<Melhoria> findByDepartamentoMelhoria(Departamento departamento);

    List<Melhoria> findByStatus(StatusEtapa status);

    List<Melhoria> findByTituloContainingIgnoreCase(String titulo);
}