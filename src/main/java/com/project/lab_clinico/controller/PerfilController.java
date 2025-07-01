package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.PerfilEntity;
import com.project.lab_clinico.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfiles")
@CrossOrigin(origins = "*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilEntity> listar() {
        return perfilService.listarPerfiles();
    }

    @GetMapping("/{id}")
    public Optional<PerfilEntity> obtenerPorId(@PathVariable Long id) {
        return perfilService.obtenerPerfilPorId(id);
    }

    @GetMapping("/area/{areaId}")
    public List<PerfilEntity> listarPorArea(@PathVariable Long areaId) {
        return perfilService.listarPerfilesPorArea(areaId);
    }

    @PostMapping
    public PerfilEntity crear(@RequestBody PerfilEntity perfil) {
        return perfilService.guardarPerfil(perfil);
    }

    @PutMapping("/{id}")
    public PerfilEntity actualizar(@PathVariable Long id, @RequestBody PerfilEntity perfil) {
        perfil.setId(id);
        return perfilService.guardarPerfil(perfil);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        perfilService.eliminarPerfil(id);
    }
}
