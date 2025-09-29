package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusEtapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MelhoriaRepository extends JpaRepository<Melhoria, Long> {

    List<Melhoria> findByResponsavelId(Long responsavelId);
    List<Melhoria> findByDepartamentoMelhoria(Departamento departamento);
    List<Melhoria> findByStatus(StatusEtapa status);
    List<Melhoria> findByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT m FROM Melhoria m JOIN m.responsavel u WHERE u.email = :email")
    List<Melhoria> findByResponsavelEmail(String email);
}