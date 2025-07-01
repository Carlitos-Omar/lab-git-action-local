package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.ValoresReferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValoresReferenciaRepository extends JpaRepository<ValoresReferenciaEntity, Integer> {
    Optional<ValoresReferenciaEntity> findByParametroIdParametro(Integer idParametro);

}