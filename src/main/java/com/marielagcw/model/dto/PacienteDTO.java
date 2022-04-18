package com.marielagcw.model.dto;

import com.marielagcw.model.entity.Domicilio;

import java.time.LocalDate;

public class PacienteDTO {

    // ATRIBUTOS

    private Integer id;
    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaDeIngreso;
    private Domicilio domicilio;

    // GETTERS

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public Integer getId() {
        return id;
    }

    // SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
