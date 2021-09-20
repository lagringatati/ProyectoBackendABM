package com.dh.clinica.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "turnos")
public class Turno implements Serializable {

    //atributos
    @Id
    @SequenceGenerator(name = "turnoSequence", sequenceName = "turnoSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnoSequence")
    @Column(name = "turno_id")
    private Integer id;
    private LocalDate fechaTurno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    //constructores
    public Turno() {
    }
    //sin id por ser autoincremental
    public Turno(LocalDate fechaTurno, Odontologo odontologo, Paciente paciente) {
        this.fechaTurno = fechaTurno;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    //getters y setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Odontologo getOdontologo() {
        return odontologo;
    }
    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public LocalDate getFechaTurno() {
        return fechaTurno;
    }
    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    //sobreescritura to string turno
    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fechaTurno=" + fechaTurno +
                ", odontologo=" + odontologo +
                ", paciente=" + paciente +
                '}';
    }
}