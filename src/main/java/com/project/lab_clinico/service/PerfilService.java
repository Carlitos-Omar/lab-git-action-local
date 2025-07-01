package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.PerfilEntity;

import java.util.List;
import java.util.Optional;

public interface PerfilService {
    List<PerfilEntity> listarPerfiles();
    Optional<PerfilEntity> obtenerPerfilPorId(Long id);
    List<PerfilEntity> listarPerfilesPorArea(Long areaId);
    PerfilEntity guardarPerfil(PerfilEntity perfil);
    void eliminarPerfil(Long id);
}

