package com.dh.clinica.service.impl;

import com.dh.clinica.dto.PacienteDto;
import com.dh.clinica.persistence.entities.Paciente;
import com.dh.clinica.service.IServicePaciente;
import com.dh.clinica.persistence.repositories.IPacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePacienteImpl implements IServicePaciente {

    @Autowired
    private IPacienteRepository repository;
    private ServiceDomicilioImpl domicilioService;
    private static final Logger logger = Logger.getLogger(ServicePacienteImpl.class);

    @Override
    public PacienteDto guardar(PacienteDto p) {
        p.setFechaIngreso(LocalDate.now());
        p.setId(repository.save(p.toEntity()).getId());
        return p;
    }

    //@Override
    public PacienteDto buscarPorId(Integer id) {
        return new PacienteDto(repository.getById(id));
    }

    //@Override
    public List<PacienteDto> buscarTodos() {
        List<PacienteDto> pacientes = new ArrayList<>();
        for(Paciente p : repository.findAll()){
            pacientes.add(new PacienteDto(p));
        }
        return pacientes;
    }

    @Override
    public PacienteDto actualizar(PacienteDto p) {
        repository.save(p.toEntity());
        return p;
    }

    @Override
    public void borrar(Integer id) {
        repository.deleteById(id);
    }
}
