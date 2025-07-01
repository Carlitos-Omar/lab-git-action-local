package com.project.lab_clinico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long idOrden;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacientEntity id_paciente;

    @Enumerated(EnumType.STRING)
    private StatusOrder estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    private Date fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fecha_actualizacion;

    @Column(name = "codigo_orden", unique = true, nullable = false, length = 30)
    private String codigoOrden;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_laboratorista", nullable = false)
    private LaboratoristaEntity laboratorista;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medico", nullable = false)
    private MedicoEntity medicoEntity;


    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public StatusOrder getEstado() {
        return estado;
    }

    public void setEstado(StatusOrder estado) {
        this.estado = estado;
    }

    public PacientEntity getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(PacientEntity id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public LaboratoristaEntity getLaboratorista() {
        return laboratorista;
    }

    public void setLaboratorista(LaboratoristaEntity laboratorista) {
        this.laboratorista = laboratorista;
    }

    public MedicoEntity getMedicoEntity() {
        return medicoEntity;
    }

    public void setMedicoEntity(MedicoEntity medicoEntity) {
        this.medicoEntity = medicoEntity;
    }
}

