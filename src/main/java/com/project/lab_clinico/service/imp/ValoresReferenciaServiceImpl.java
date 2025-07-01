package com.project.lab_clinico.service.imp;

import com.project.lab_clinico.entity.ValoresReferenciaEntity;
import com.project.lab_clinico.repository.ValoresReferenciaRepository;
import com.project.lab_clinico.service.ValoresReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ValoresReferenciaServiceImpl implements ValoresReferenciaService {

    @Autowired
    private ValoresReferenciaRepository repository;

    @Override
    public List<ValoresReferenciaEntity> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<ValoresReferenciaEntity> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ValoresReferenciaEntity> obtenerPorParametroId(Integer parametroId) {
        return repository.findByParametroIdParametro(parametroId);
    }

    @Override
    public ValoresReferenciaEntity guardar(ValoresReferenciaEntity valoresReferencia) {
        valoresReferencia.setFechaCreaccion(LocalDateTime.now());
        return repository.save(valoresReferencia);
    }

    @Override
    public ValoresReferenciaEntity actualizar(Integer id, ValoresReferenciaEntity valoresReferencia) {
        Optional<ValoresReferenciaEntity> existente = repository.findById(id);
        if (existente.isPresent()) {
            ValoresReferenciaEntity entidadExistente = existente.get();
            entidadExistente.setDescripcion(valoresReferencia.getDescripcion());
            entidadExistente.setFechaActualizacion(LocalDateTime.now());
            return repository.save(entidadExistente);
        } else {
            throw new RuntimeException("Valor de referencia no encontrado con ID: " + id);
        }
    }
    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
