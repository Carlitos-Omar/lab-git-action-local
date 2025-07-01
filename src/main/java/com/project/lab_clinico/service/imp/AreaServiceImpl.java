package com.project.lab_clinico.service.imp;

import com.project.lab_clinico.entity.AreaEntity;
import com.project.lab_clinico.repository.AreaRepository;
import com.project.lab_clinico.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;
    @Override
    public List<AreaEntity> findAll() {
        return areaRepository.findAll();
    }
    @Override
    public AreaEntity findById(Long id) {
        Optional<AreaEntity> optional = areaRepository.findById(id);
        return optional.orElse(null);
    }
    @Override
    public AreaEntity save(AreaEntity area) {
        String nombreNormalizado = area.getNombre().trim();

        // Verificar si ya existe un área con el mismo nombre (ignorando mayúsculas/minúsculas)
        Optional<AreaEntity> existente = areaRepository.findByNombreIgnoreCase(nombreNormalizado);
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un área con ese nombre.");
        }

        area.setNombre(nombreNormalizado);
        return areaRepository.save(area);
    }

    @Override
    public void deleteById(Long id) {
        areaRepository.deleteById(id);
    }
}
