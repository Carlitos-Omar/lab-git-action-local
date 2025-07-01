package com.project.lab_clinico.service.imp;

import com.project.lab_clinico.dto.ActualizarParametroPerfilDTO;
import com.project.lab_clinico.dto.CrearParametroPerfilDTO;
import com.project.lab_clinico.dto.perfiles.ParametroResumenDTO;
import com.project.lab_clinico.dto.perfiles.PerfilConParametrosDTO;
import com.project.lab_clinico.entity.ParametroEntity;
import com.project.lab_clinico.entity.PerfilEntity;
import com.project.lab_clinico.entity.PerfilParametroEntity;
import com.project.lab_clinico.entity.UnidadEntity;
import com.project.lab_clinico.repository.ParametroRepository;
import com.project.lab_clinico.repository.PerfilParametroRepository;
import com.project.lab_clinico.repository.PerfilRepository;
import com.project.lab_clinico.repository.UnidadRepository;
import com.project.lab_clinico.service.PerfilParametroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerfilParametroServiceImpl implements PerfilParametroService {

    @Autowired
    private ParametroRepository parametroRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UnidadRepository unidadRepository;

    @Autowired
    private PerfilParametroRepository repository;

    @Override
    public List<PerfilParametroEntity> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<PerfilParametroEntity> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PerfilParametroEntity> findByPerfilId(Long idPerfil) {
        return repository.findByPerfilId(idPerfil);
    }

    @Override
    public PerfilConParametrosDTO obtenerPerfilConParametros(Long idPerfil) {
        PerfilEntity perfil = perfilRepository.findById(idPerfil)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        List<PerfilParametroEntity> asociaciones = repository.findByPerfilId(idPerfil);

        List<ParametroResumenDTO> parametrosDTO = asociaciones.stream()
                .map(pp -> {
                    ParametroResumenDTO dto = new ParametroResumenDTO();
                    dto.setIdParametro(pp.getParametro().getIdParametro());
                    dto.setNombre(pp.getParametro().getNombre());
                    dto.setUnidad(pp.getParametro().getUnidad().getNombre());
                    return dto;
                })
                .collect(Collectors.toList());


        PerfilConParametrosDTO respuesta = new PerfilConParametrosDTO();
        respuesta.setNombrePerfil(perfil.getNombre());
        respuesta.setParametros(parametrosDTO);

        return respuesta;
    }


    @Override
    @Transactional
    public PerfilParametroEntity crearParametroYAsociarPerfil(CrearParametroPerfilDTO dto) {
        // Validar existencia de perfil y unidad
        PerfilEntity perfil = perfilRepository.findById(dto.getIdPerfil())
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        UnidadEntity unidad = unidadRepository.findById(dto.getParametro().getIdUnidad())
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        String nombreParametro = dto.getParametro().getNombre().trim();

        // Verificar si ya existe un parámetro con el mismo nombre (ignorar mayúsculas)
        Optional<ParametroEntity> existente = parametroRepository.findByNombreIgnoreCase(nombreParametro);
        if (existente.isPresent()) {
            throw new RuntimeException("Ya existe un parámetro con ese nombre: " + nombreParametro);
        }

        // Crear el parámetro
        ParametroEntity parametro = new ParametroEntity();
        parametro.setNombre(nombreParametro);
        parametro.setEsAnalisis(dto.getParametro().isEsAnalisis());
        parametro.setUnidad(unidad);
        parametro = parametroRepository.save(parametro);

        // Asociar con perfil
        PerfilParametroEntity perfilParametro = new PerfilParametroEntity();
        perfilParametro.setPerfil(perfil);
        perfilParametro.setParametro(parametro);

        return repository.save(perfilParametro);
    }

    @Override
    @Transactional
    public PerfilParametroEntity actualizarParametroPerfil(ActualizarParametroPerfilDTO dto) {
        PerfilParametroEntity perfilParametro = repository.findById(dto.getIdPerfilParametro())
                .orElseThrow(() -> new RuntimeException("Perfil-Parametro no encontrado"));

        ParametroEntity parametro = perfilParametro.getParametro();
        String nuevoNombre = dto.getNombre().trim();

        // Validar si ya existe otro parámetro con ese nombre (ignorando mayúsculas)
        Optional<ParametroEntity> existente = parametroRepository.findByNombreIgnoreCase(nuevoNombre);
        if (existente.isPresent() && !existente.get().getIdParametro().equals(parametro.getIdParametro())) {
            throw new RuntimeException("Ya existe un parámetro con ese nombre: " + nuevoNombre);
        }
        // Actualizar los campos
        parametro.setNombre(nuevoNombre);
        parametro.setEsAnalisis(dto.isEsAnalisis());

        UnidadEntity unidad = unidadRepository.findById(dto.getIdUnidad())
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        parametro.setUnidad(unidad);

        parametroRepository.save(parametro);

        return perfilParametro;
    }


    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
