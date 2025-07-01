package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.ParametroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParametroRepository extends JpaRepository<ParametroEntity, Long> {
    Optional<ParametroEntity> findByNombreIgnoreCase(String nombre);

}