package com.marielagcw.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="dentist")
public class Odontologo {

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="identity_number")
    private Integer numeroMatricula;
    @Column(name="lastname")
    private String apellido;
    @Column(name="name")
    private String nombre;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> listadoTurnos = new HashSet<>();

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
}
