package com.project.lab_clinico.service;

import com.project.lab_clinico.entity.ValoresReferenciaEntity;

import java.util.List;
import java.util.Optional;

public interface ValoresReferenciaService {
    List<ValoresReferenciaEntity> obtenerTodos();
    Optional<ValoresReferenciaEntity> obtenerPorId(Integer id);
    Optional<ValoresReferenciaEntity> obtenerPorParametroId(Integer parametroId);
    ValoresReferenciaEntity guardar(ValoresReferenciaEntity valoresReferencia);
    ValoresReferenciaEntity actualizar(Integer id, ValoresReferenciaEntity valoresReferencia);
    void eliminar(Integer id);
}