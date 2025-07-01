package com.project.lab_clinico.service;

import com.project.lab_clinico.dto.ActualizarParametroPerfilDTO;
import com.project.lab_clinico.dto.CrearParametroPerfilDTO;
import com.project.lab_clinico.dto.perfiles.PerfilConParametrosDTO;
import com.project.lab_clinico.entity.PerfilParametroEntity;

import java.util.List;
import java.util.Optional;

public interface PerfilParametroService {
    List<PerfilParametroEntity> listarTodos();
    Optional<PerfilParametroEntity> obtenerPorId(Long id);
    List<PerfilParametroEntity> findByPerfilId(Long idPerfil);
    public PerfilConParametrosDTO obtenerPerfilConParametros(Long idPerfil);
    PerfilParametroEntity crearParametroYAsociarPerfil(CrearParametroPerfilDTO dto);
    PerfilParametroEntity actualizarParametroPerfil(ActualizarParametroPerfilDTO dto);
    void eliminar(Long id);
}