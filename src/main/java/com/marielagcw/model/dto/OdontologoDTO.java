package com.marielagcw.model.dto;

public class OdontologoDTO {

    // ATRIBUTOS

    private Integer id;
    private Integer numeroMatricula;
    private String apellido;
    private String nombre;

    // GETTERS
    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    // SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
