package com.project.lab_clinico.controller;

import com.project.lab_clinico.entity.ValoresReferenciaEntity;
import com.project.lab_clinico.service.ValoresReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/valores-referencia")
public class ValoresReferenciaController {

    @Autowired
    private ValoresReferenciaService service;

    @GetMapping
    public ResponseEntity<List<ValoresReferenciaEntity>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValoresReferenciaEntity> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/parametro/{parametroId}")
    public ResponseEntity<ValoresReferenciaEntity> obtenerPorParametro(@PathVariable Integer parametroId) {
        return service.obtenerPorParametroId(parametroId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ValoresReferenciaEntity> crear(@RequestBody ValoresReferenciaEntity valoresReferencia) {
        return ResponseEntity.ok(service.guardar(valoresReferencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValoresReferenciaEntity> actualizar(@PathVariable Integer id, @RequestBody ValoresReferenciaEntity valoresReferencia) {
        return ResponseEntity.ok(service.actualizar(id, valoresReferencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
