package com.project.lab_clinico.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
@Table(name = "parametros")
public class ParametroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Long idParametro;

    @Column(unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_unidad", nullable = false)
    private UnidadEntity unidad;

    @Column(name = "es_analisis")
    private Boolean esAnalisis;

    // Getters y Setters
    public Long getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Long idParametro) {
        this.idParametro = idParametro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadEntity getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadEntity unidad) {
        this.unidad = unidad;
    }

    public Boolean getEsAnalisis() {
        return esAnalisis;
    }

    public void setEsAnalisis(Boolean esAnalisis) {
        this.esAnalisis = esAnalisis;
    }

}