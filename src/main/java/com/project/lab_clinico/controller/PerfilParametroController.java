package com.project.lab_clinico.controller;

import com.project.lab_clinico.dto.ActualizarParametroPerfilDTO;
import com.project.lab_clinico.dto.CrearParametroPerfilDTO;
import com.project.lab_clinico.dto.perfiles.PerfilConParametrosDTO;
import com.project.lab_clinico.entity.PerfilParametroEntity;
import com.project.lab_clinico.service.PerfilParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfil_parametro")
@CrossOrigin(origins = "*")
public class PerfilParametroController {

    @Autowired
    private PerfilParametroService service;

    @GetMapping
    public List<PerfilParametroEntity> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<PerfilParametroEntity> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/perfil/{idPerfil}/parametros")
    public PerfilConParametrosDTO obtenerPerfilConParametros(@PathVariable Long idPerfil) {
        return service.obtenerPerfilConParametros(idPerfil);
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CrearParametroPerfilDTO dto) {
        try {
            PerfilParametroEntity resultado = service.crearParametroYAsociarPerfil(dto);
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody ActualizarParametroPerfilDTO dto) {
        try {
            PerfilParametroEntity actualizado = service.actualizarParametroPerfil(dto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/perfil/{idPerfil}")
    public List<PerfilParametroEntity> getParametrosPorPerfil(@PathVariable Long idPerfil) {
        return service.findByPerfilId(idPerfil);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
