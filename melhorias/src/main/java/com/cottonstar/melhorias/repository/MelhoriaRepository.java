package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Melhoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MelhoriaRepository extends JpaRepository<Melhoria, String> {
    // Exemplos de consultas customizadas:
    // List<Melhoria> findByDepartamentoMelhoria(Departamento departamento);
    // List<Melhoria> findByStatus(StatusMelhoria status);
}