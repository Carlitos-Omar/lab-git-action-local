package com.project.lab_clinico.controller;

import com.project.lab_clinico.dto.Ordendetalle.CrearOrderDetailDTO;
import com.project.lab_clinico.entity.OrderDetailEntity;
import com.project.lab_clinico.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-orden")
@CrossOrigin(origins = "*")
public class OrderDetailController {

    @Autowired
    private OrderDetailService detailService;

    @GetMapping
    public List<OrderDetailEntity> getAllDetails() {
        return detailService.getAllDetails();
    }

    @GetMapping("/{id}")
    public Optional<OrderDetailEntity> getDetailById(@PathVariable Long id) {
        return detailService.getDetailById(id);
    }

    @GetMapping("/orden/{idOrden}")
    public List<OrderDetailEntity> getDetailsByOrderId(@PathVariable Long idOrden) {
        return detailService.getDetailsByOrderId(idOrden);
    }

    @PostMapping
    public ResponseEntity<?> createDetail(@RequestBody CrearOrderDetailDTO dto) {
        List<OrderDetailEntity> detallesGuardados = detailService.createDetails(dto);
        return ResponseEntity.ok(detallesGuardados);
    }


    @PutMapping("/{id}")
    public OrderDetailEntity updateDetail(@PathVariable Long id, @RequestBody OrderDetailEntity detalle) {
        return detailService.updateDetail(id, detalle);
    }

    @DeleteMapping("/{id}")
    public void deleteDetail(@PathVariable Long id) {
        detailService.deleteDetail(id);
    }
}
