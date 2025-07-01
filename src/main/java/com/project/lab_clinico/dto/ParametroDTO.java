package com.project.lab_clinico.dto;


public class ParametroDTO {
    private String nombre;
    private boolean esAnalisis;
    private Integer idUnidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public boolean isEsAnalisis() {
        return esAnalisis;
    }

    public void setEsAnalisis(boolean esAnalisis) {
        this.esAnalisis = esAnalisis;
    }
}
