package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.MelhoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MelhoriaRepository extends JpaRepository<MelhoriaModel, String> {
    // Exemplos de consultas customizadas:
    // List<Melhoria> findByDepartamentoMelhoria(Departamento departamento);
    // List<Melhoria> findByStatus(StatusMelhoria status);
}