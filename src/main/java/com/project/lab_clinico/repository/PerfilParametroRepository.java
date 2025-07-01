package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.PerfilParametroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilParametroRepository extends JpaRepository<PerfilParametroEntity, Long> {
    List<PerfilParametroEntity> findByPerfilId(Long idPerfil);

}