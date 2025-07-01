package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
    Optional<AreaEntity> findByNombreIgnoreCase(String nombre);
}