package com.project.lab_clinico.service;

import com.project.lab_clinico.dto.Ordendetalle.CrearOrderDetailDTO;
import com.project.lab_clinico.entity.OrderDetailEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetailEntity> getAllDetails();
    Optional<OrderDetailEntity> getDetailById(Long id);
    List<OrderDetailEntity> getDetailsByOrderId(Long idOrden);
    List<OrderDetailEntity> createDetails(CrearOrderDetailDTO dto);
    OrderDetailEntity updateDetail(Long id, OrderDetailEntity detalle);
    void deleteDetail(Long id);
}
