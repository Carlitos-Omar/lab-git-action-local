package com.project.lab_clinico.dto.Ordendetalle;

import java.util.List;

public class CrearOrderDetailDTO {
    private Long idOrden;
    private List<Long> idsParametros;

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public List<Long> getIdsParametros() {
        return idsParametros;
    }

    public void setIdsParametros(List<Long> idsParametros) {
        this.idsParametros = idsParametros;
    }
}
