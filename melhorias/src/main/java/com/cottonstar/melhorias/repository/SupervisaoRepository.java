package com.cottonstar.melhorias.repository;

import com.cottonstar.melhorias.model.Supervisao;
import com.cottonstar.melhorias.model.enums.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupervisaoRepository extends JpaRepository<Supervisao, Long> {

    Optional<Supervisao> findByDepartamento(Departamento departamento);
}