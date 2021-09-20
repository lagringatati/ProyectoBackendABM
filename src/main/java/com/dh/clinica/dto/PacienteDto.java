package com.dh.clinica.dto;

import com.dh.clinica.persistence.entities.Paciente;
import java.time.LocalDate;

public class PacienteDto{
    //atributos
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso;
    private DomicilioDto domicilio;

    //constructores
    public PacienteDto(){
    }
    public PacienteDto(Paciente p){
        id = p.getId();
        nombre = p.getNombre();
        apellido = p.getApellido();
        dni = p.getDni();
        fechaIngreso = p.getFechaIngreso();
        domicilio = new DomicilioDto(p.getDomicilio());
    }

    //getters y setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public DomicilioDto getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(DomicilioDto domicilio) {
        this.domicilio = domicilio;
    }

    //entidad de persistencia en la db
    public Paciente toEntity(){
        Paciente entity = new Paciente();
        entity.setId(id);
        entity.setApellido(apellido);
        entity.setDni(dni);
        entity.setNombre(nombre);
        entity.setFechaIngreso(fechaIngreso);
        entity.setDomicilio(domicilio.toEntity());
        return entity;
    }
}