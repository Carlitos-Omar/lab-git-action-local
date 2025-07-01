package com.project.lab_clinico.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "valores_referencia")
public class ValoresReferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valor_referencia")
    private Integer idValorReferencia;

    @ManyToOne
    @JoinColumn(name = "id_parametro", nullable = false)
    private ParametroEntity parametro;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_creaccion", nullable = false)
    private LocalDateTime fechaCreaccion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Integer getIdValorReferencia() {
        return idValorReferencia;
    }

    public void setIdValorReferencia(Integer idValorReferencia) {
        this.idValorReferencia = idValorReferencia;
    }

    public ParametroEntity getParametro() {
        return parametro;
    }

    public void setParametro(ParametroEntity parametro) {
        this.parametro = parametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreaccion() {
        return fechaCreaccion;
    }

    public void setFechaCreaccion(LocalDateTime fechaCreaccion) {
        this.fechaCreaccion = fechaCreaccion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}