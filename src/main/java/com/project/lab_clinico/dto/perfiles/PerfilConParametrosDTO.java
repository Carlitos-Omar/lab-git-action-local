package com.project.lab_clinico.dto.perfiles;

import com.project.lab_clinico.dto.ParametroDTO;

import java.util.List;

public class PerfilConParametrosDTO {
    private String nombrePerfil;
    private List<ParametroResumenDTO> parametros;

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public List<ParametroResumenDTO> getParametros() {
        return parametros;
    }

    public void setParametros(List<ParametroResumenDTO> parametros) {
        this.parametros = parametros;
    }
}
