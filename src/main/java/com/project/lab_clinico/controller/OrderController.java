package com.project.lab_clinico.controller;

import com.project.lab_clinico.dto.orden.OrderRequestDTO;
import com.project.lab_clinico.dto.orden.OrderResumenDTO;
import com.project.lab_clinico.entity.OrderEntity;
import com.project.lab_clinico.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*") // Para permitir llamadas desde tu frontend PHP
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/resumen")
    public ResponseEntity<List<OrderResumenDTO>> getResumenOrdenes() {
        return ResponseEntity.ok(orderService.getResumenOrdenes());
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/codigo/{codigo}")
    public Optional<OrderEntity> getOrderByCodigo(@PathVariable String codigo) {
        return orderService.getOrderByCodigo(codigo);
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderRequestDTO dto) {
        return orderService.createOrder(dto);
    }
    @PutMapping("/{id}")
    public OrderEntity updateOrder(@PathVariable Long id, @RequestBody OrderEntity order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}

