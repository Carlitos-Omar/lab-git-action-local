package com.project.lab_clinico.dto.orden;

public class OrderRequestDTO {
    private Long idPaciente;
    private Long idMedico;
    private Long idLaboratorista;

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdLaboratorista() {
        return idLaboratorista;
    }

    public void setIdLaboratorista(Long idLaboratorista) {
        this.idLaboratorista = idLaboratorista;
    }
}
