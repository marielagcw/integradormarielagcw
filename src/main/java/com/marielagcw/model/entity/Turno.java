package com.marielagcw.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Turno {

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDateTime fechaHora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id")
    private Paciente paciente;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private Odontologo odontologo;

    // GETTERS
    public Integer getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

}
