package com.project.lab_clinico.dto;


public class ActualizarParametroPerfilDTO {
    private Long idPerfilParametro;   // ID del perfil-parametro existente
    private String nombre;            // Nombre nuevo
    private boolean esAnalisis;       // Estado nuevo
    private Integer idUnidad;

    public Long getIdPerfilParametro() {
        return idPerfilParametro;
    }

    public void setIdPerfilParametro(Long idPerfilParametro) {
        this.idPerfilParametro = idPerfilParametro;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
