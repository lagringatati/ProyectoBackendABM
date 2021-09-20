package com.dh.clinica.service.impl;

import com.dh.clinica.dto.DomicilioDto;
import com.dh.clinica.persistence.entities.Domicilio;
import com.dh.clinica.persistence.repositories.IDomicilioRepository;
import com.dh.clinica.service.IServiceDomicilio;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDomicilioImpl implements IServiceDomicilio {

    @Autowired
    private IDomicilioRepository repository;
    private static final Logger logger = Logger.getLogger(ServiceDomicilioImpl.class);


    @Override
    public DomicilioDto guardar(DomicilioDto domicilio) {
        domicilio.setId(repository.save(domicilio.toEntity()).getId());
        return domicilio;
    }

    @Override
    public List<DomicilioDto> buscarTodos() {
        List<DomicilioDto> domicilios = new ArrayList<>();
        for(Domicilio d: repository.findAll()){
            domicilios.add(new DomicilioDto(d));
        }
        return domicilios;
    }

    @Override
    public DomicilioDto buscarPorId(Integer id) {
        return new DomicilioDto(repository.getById(id));
    }

    @Override
    public DomicilioDto actualizar (DomicilioDto d){
        repository.save(d.toEntity());
        return d;
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }
}
