package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Melhoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MelhoriaRepository extends JpaRepository<Melhoria, Integer> {          // PASSAR ENTIDADE E O TIPO
    // Exemplos de consultas customizadas:
    // List<Melhoria> findByDepartamentoMelhoria(Departamento departamento);
    // List<Melhoria> findByStatus(StatusMelhoria status);
}