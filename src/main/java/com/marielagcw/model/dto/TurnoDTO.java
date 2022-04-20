package com.marielagcw.model.dto;

import java.time.LocalDateTime;

public class TurnoDTO {

    // ATRIBUTOS
    private Integer id;
    private LocalDateTime fechaHora;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;

    // GETTERS

    public Integer getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public OdontologoDTO getOdontologo() {
        return odontologo;
    }

    // SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public void setOdontologo(OdontologoDTO odontologo) {
        this.odontologo = odontologo;
    }
}
