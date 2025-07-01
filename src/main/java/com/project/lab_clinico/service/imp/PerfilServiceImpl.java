package com.project.lab_clinico.service.imp;

import com.project.lab_clinico.entity.PerfilEntity;
import com.project.lab_clinico.repository.PerfilRepository;
import com.project.lab_clinico.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<PerfilEntity> listarPerfiles() {
        return perfilRepository.findAll();
    }

    @Override
    public Optional<PerfilEntity> obtenerPerfilPorId(Long id) {
        return perfilRepository.findById(id);
    }

    @Override
    public List<PerfilEntity> listarPerfilesPorArea(Long areaId) {
        return perfilRepository.findByArea_Id(areaId);
    }

    @Override
    public PerfilEntity guardarPerfil(PerfilEntity perfil) {
        String nombreNormalizado = perfil.getNombre().trim();

        // Verificar si ya existe un perfil con el mismo nombre (sin importar mayúsculas/minúsculas)
        Optional<PerfilEntity> existente = perfilRepository.findByNombreIgnoreCase(nombreNormalizado);
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un perfil con el nombre '" + nombreNormalizado + "'.");
        }

        perfil.setNombre(nombreNormalizado);
        return perfilRepository.save(perfil);
    }
    @Override
    public void eliminarPerfil(Long id) {
        perfilRepository.deleteById(id);
    }
}
