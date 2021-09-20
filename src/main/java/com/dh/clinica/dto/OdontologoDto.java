package com.dh.clinica.dto;

import com.dh.clinica.persistence.entities.Odontologo;

public class OdontologoDto {
    //atributos
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;

    //constructores
    public OdontologoDto() {
    }
    public OdontologoDto(Integer id){
        this.id = id;
    }
    //sin id por ser autoincremental
    public OdontologoDto(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
    public OdontologoDto(Integer id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
    public OdontologoDto (Odontologo o){
        id = o.getId();
        nombre = o.getNombre();
        apellido = o.getApellido();
        matricula = o.getMatricula();
    }
    //setters y getters
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
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //entidad de persistencia en la db
    public Odontologo toEntity (){
        Odontologo entity = new Odontologo();
        entity.setId(id);
        entity.setNombre(nombre);
        entity.setApellido(apellido);
        entity.setMatricula(matricula);
        return  entity;
    }
}