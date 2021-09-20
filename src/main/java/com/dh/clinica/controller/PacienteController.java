package com.dh.clinica.controller;

import com.dh.clinica.dto.PacienteDto;
import com.dh.clinica.service.IServicePaciente;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IServicePaciente service;
    private static final Logger logger = Logger.getLogger(PacienteController.class);

    //buscar y mostrar todos los pacientes
    @GetMapping("/todos")
    public ResponseEntity<List<PacienteDto>> buscarTodosLosPacientes() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    //buscar un paciente determinado por id
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPacientePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    //crear un nuevo paciente
    @PostMapping("/nuevo")
    public ResponseEntity<PacienteDto> crearNuevoPaciente(@RequestBody PacienteDto paciente){
        return ResponseEntity.ok(service.guardar(paciente));
    }

    //actualizar un paciente
    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody PacienteDto paciente){
        if(paciente.getId() != null) {
            return ResponseEntity.ok(service.actualizar(paciente));
        }else{
            return ResponseEntity.badRequest().body(paciente);
        }
    }

    //borrar un paciente por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPacientePorId(@PathVariable Integer id) {
        try {
            service.borrar(id);
        } catch (Exception e) {
            logger.debug(String.format("No se encuentra el paciente con id %s", id));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(String.format("El paciente %s fue eliminado", id));
    }
}