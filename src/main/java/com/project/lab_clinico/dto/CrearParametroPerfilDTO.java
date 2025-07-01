package com.project.lab_clinico.dto;

public class CrearParametroPerfilDTO {
    private Long idPerfil;
    private ParametroDTO parametro;

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public ParametroDTO getParametro() {
        return parametro;
    }

    public void setParametro(ParametroDTO parametro) {
        this.parametro = parametro;
    }
}

