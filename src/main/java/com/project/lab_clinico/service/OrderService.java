package com.project.lab_clinico.service;

import com.project.lab_clinico.dto.orden.OrderRequestDTO;
import com.project.lab_clinico.dto.orden.OrderResumenDTO;
import com.project.lab_clinico.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderEntity> getAllOrders();
    Optional<OrderEntity> getOrderById(Long id);
    List<OrderResumenDTO> getResumenOrdenes();
    Optional<OrderEntity> getOrderByCodigo(String codigo);
    OrderEntity createOrder(OrderRequestDTO order);
    OrderEntity updateOrder(Long id, OrderEntity order);
    void deleteOrder(Long id);
}
