package com.marielagcw.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Domicilio {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "street")
    private String calle;
    @Column(name = "number")
    private Integer numero;
    @Column(name = "city")
    private String localidad;
    @Column(name = "state")
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
