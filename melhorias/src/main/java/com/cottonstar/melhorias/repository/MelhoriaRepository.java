package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Melhoria;
import com.cottonstar.melhorias.model.enums.Departamento;
import com.cottonstar.melhorias.model.enums.StatusMelhoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MelhoriaRepository extends JpaRepository<Melhoria, Long> {          // PASSAR OBJETO E O TIPO

    // Spring entende: "SELECT * FROM tb_melhorias WHERE responsavel_fk = ?             // FILTRADO ATRVÉS DO USUARIO LOGADO
    List<Melhoria> findByResponsavelId(Integer responsavelId);                          // CONSULTA MELHORIAS ATRAVÉS DO ID DO RESPONSÁVEL

    // FILTROS ESPECÍFICOS

    // Spring entende: "SELECT * FROM tb_melhorias WHERE departamento = ?"              // FILTRADO PELO USUARIO
    List<Melhoria> findByDepartamentoMelhoria(Departamento departamento);               // CONSULTA MELHORIAS ATRAVÉS DO DEPARTAMENTO

    // Spring entende: "SELECT * FROM tb_melhorias WHERE status = ?"                    // FILTRADO PELO USUARIO
    List<Melhoria> findByStatus(StatusMelhoria status);                                 // CONSULTA MELHORIAS ATRAVÉS DO STATUS

    // Spring entende: "SELECT * FROM tb_melhorias WHERE lower(titulo) LIKE lower(?)"   // FILTRADO PELO USUARIO
    List<Melhoria> findByTituloContainingIgnoreCase(String titulo);                     // CONSULTA MELHORIAS ATRAVÉS DO TÍTULO, IGNORANDO MAIÚSCULAS/MINÚSCULAS
}