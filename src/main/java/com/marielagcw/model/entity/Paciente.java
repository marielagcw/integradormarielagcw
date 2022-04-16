package com.marielagcw.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Paciente {

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "lastname")
    private String apellido;
    @Column(name = "name")
    private String nombre;
    @Column(name = "dni")
    private String dni;
    @Column(name = "date")
    private LocalDate fechaDeIngreso;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> listadoTurnos = new HashSet<>();

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

    public Domicilio getDomicilio() {
        return domicilio;
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
}
