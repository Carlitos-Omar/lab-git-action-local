package com.project.lab_clinico.repository;

import com.project.lab_clinico.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {
    Optional<PerfilEntity> findByNombreIgnoreCase(String nombre);
    List<PerfilEntity> findByArea_Id(Long areaId);  // <--- ahora esto sí funciona

}
