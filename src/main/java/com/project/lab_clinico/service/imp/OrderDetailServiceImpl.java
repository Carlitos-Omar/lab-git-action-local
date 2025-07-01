package com.project.lab_clinico.service.imp;

import com.project.lab_clinico.dto.Ordendetalle.CrearOrderDetailDTO;
import com.project.lab_clinico.entity.OrderDetailEntity;
import com.project.lab_clinico.entity.OrderEntity;
import com.project.lab_clinico.entity.ParametroEntity;
import com.project.lab_clinico.repository.OrderDetailRepository;
import com.project.lab_clinico.repository.OrderRepository;
import com.project.lab_clinico.repository.ParametroRepository;
import com.project.lab_clinico.service.OrderDetailService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository detailRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<OrderDetailEntity> getAllDetails() {
        return detailRepository.findAll();
    }

    @Override
    public Optional<OrderDetailEntity> getDetailById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public List<OrderDetailEntity> getDetailsByOrderId(Long idOrden) {
        return detailRepository.findByOrdenIdOrden(idOrden);
    }

    @Override
    public List<OrderDetailEntity> createDetails(CrearOrderDetailDTO dto) {
        List<OrderDetailEntity> detalles = new ArrayList<>();

        // 🔍 Validar si la orden realmente existe en BD
        OrderEntity orden = orderRepository.findById(dto.getIdOrden())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + dto.getIdOrden()));

        for (Long idParam : dto.getIdsParametros()) {
            ParametroEntity parametro = new ParametroEntity();
            parametro.setIdParametro(idParam);

            OrderDetailEntity detalle = new OrderDetailEntity();
            detalle.setOrden(orden); // ✅ ahora es una entidad válida, gestionada
            detalle.setParametro(parametro);
            detalle.setFechaCreacion(LocalDateTime.now());
            detalle.setFechaActualizacion(LocalDateTime.now());

            detalles.add(detailRepository.save(detalle));
        }

        return detalles;
    }
    @Override
    public OrderDetailEntity updateDetail(Long id, OrderDetailEntity detalle) {
        Optional<OrderDetailEntity> optional = detailRepository.findById(id);
        if (optional.isPresent()) {
            OrderDetailEntity existente = optional.get();
            existente.setOrden(detalle.getOrden());
            existente.setParametro(detalle.getParametro());
            // Las fechas se actualizan solas con @PreUpdate
            return detailRepository.save(existente);
        } else {
            throw new RuntimeException("Detalle no encontrado con ID: " + id);
        }
    }

    @Override
    public void deleteDetail(Long id) {
        detailRepository.deleteById(id);
    }
}
