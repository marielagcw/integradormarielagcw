package com.marielagcw.model.dto;

import com.marielagcw.model.entity.Odontologo;
import com.marielagcw.model.entity.Paciente;
import java.time.LocalDateTime;

public class TurnoDTO {

    // ATRIBUTOS
    private Integer id;
    private LocalDateTime fechaHora;
    private Paciente paciente;
    private Odontologo odontologo;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
