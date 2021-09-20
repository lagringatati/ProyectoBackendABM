package com.dh.clinica.service.impl;

import com.dh.clinica.dto.OdontologoDto;
import com.dh.clinica.persistence.repositories.IOdontologoRepository;
import com.dh.clinica.service.IServiceOdontologo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOdontologoImpl implements IServiceOdontologo {

    @Autowired
    private IOdontologoRepository repository;
    private static final Logger logger = Logger.getLogger(ServiceOdontologoImpl.class);

    @Override
    public OdontologoDto guardar (OdontologoDto odontologo){
        odontologo.setId(repository.save(odontologo.toEntity()).getId());
        return odontologo;
    }

    @Override
    public List<OdontologoDto> buscarTodos(){
        List <OdontologoDto> odontologos = repository.findAll().stream().map(o -> new OdontologoDto(o)).collect(Collectors.toList());
        return odontologos;
    }

    @Override
    public OdontologoDto buscarPorId(Integer id) {
        return new OdontologoDto(repository.getById(id));
    }

    @Override
    public OdontologoDto actualizar (OdontologoDto o){
        repository.save(o.toEntity());
        return o;
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }
}