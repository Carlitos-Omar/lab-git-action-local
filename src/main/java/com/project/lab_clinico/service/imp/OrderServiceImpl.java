package com.project.lab_clinico.service.imp;

import com.project.lab_clinico.dto.orden.OrderRequestDTO;
import com.project.lab_clinico.dto.orden.OrderResumenDTO;
import com.project.lab_clinico.entity.OrderEntity;
import com.project.lab_clinico.entity.StatusOrder;
import com.project.lab_clinico.repository.*;
import com.project.lab_clinico.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PacientRepository pacientRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private LaboratoristaRepository laboratoristaRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);    }

    @Override
    public List<OrderResumenDTO> getResumenOrdenes() {
        List<OrderEntity> ordenes = orderRepository.findAll();

        return ordenes.stream().map(order -> {
            OrderResumenDTO dto = new OrderResumenDTO();

            dto.setCodigoOrden(order.getCodigoOrden());
            dto.setNombrePaciente(order.getId_paciente().getUserEntity().getNombres());
            dto.setApellidoPaciente(order.getId_paciente().getUserEntity().getApellidos());
            dto.setDniPaciente(order.getId_paciente().getUserEntity().getDni());
            dto.setNumeroHistoria(order.getId_paciente().getNumero_historia());
            dto.setNombreMedico(order.getMedicoEntity().getUserEntity().getNombres());
            dto.setEstado(order.getEstado().name());
            dto.setId(order.getIdOrden());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderEntity> getOrderByCodigo(String codigo) {
        return orderRepository.findByCodigoOrden(codigo);    }

    public OrderEntity createOrder(OrderRequestDTO dto) {
        OrderEntity order = new OrderEntity();
        // Buscar entidades por ID
        order.setId_paciente(pacientRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado")));

        order.setMedicoEntity(medicoRepository.findById(dto.getIdMedico())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado")));

        order.setLaboratorista(laboratoristaRepository.findById(dto.getIdLaboratorista())
                .orElseThrow(() -> new RuntimeException("Laboratorista no encontrado")));
        // Seteo automático
        order.setFecha_creacion(new Date());
        order.setFecha_actualizacion(new Date());
        order.setEstado(StatusOrder.PENDIENTE);
        order.setCodigoOrden("TEMP");
        OrderEntity savedOrder = orderRepository.save(order);
        String codigo = String.format("ORD-%04d", savedOrder.getIdOrden());
        savedOrder.setCodigoOrden(codigo);
        return orderRepository.save(savedOrder);
    }

    @Override
    public OrderEntity updateOrder(Long id, OrderEntity order) {
        Optional<OrderEntity> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            OrderEntity existente = optional.get();
            existente.setEstado(order.getEstado());
            existente.setFecha_actualizacion(new Date());
            existente.setId_paciente(order.getId_paciente());
            existente.setLaboratorista(order.getLaboratorista());
            existente.setMedicoEntity(order.getMedicoEntity());
            return orderRepository.save(existente);
        } else {
            throw new RuntimeException("Orden no encontrada con ID: " + id);
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
