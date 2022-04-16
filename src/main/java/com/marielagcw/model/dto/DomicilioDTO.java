package com.marielagcw.model.dto;

public class DomicilioDTO {

    //ATRIBUTOS
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

    //GETTERS
    public String getCalle() {
        return calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public Integer getId() {
        return id;
    }

    // SETTERS
    public void setId(Integer id) {
        this.id = id;
    }
}
