package com.dh.clinica.controller;

import com.dh.clinica.dto.DomicilioDto;
import com.dh.clinica.service.impl.ServiceDomicilioImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private ServiceDomicilioImpl service;
    private static final Logger logger = Logger.getLogger(DomicilioController.class);

    //buscar y mostrar todos
    @GetMapping("/todos")
    public ResponseEntity<List<DomicilioDto>> buscarTodosLosDomicilios(){
        return ResponseEntity.ok(service.buscarTodos());
    }
    //buscar y taer por id
    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDto> buscarDomicilioPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    //crear un nuevo domicilio
    @PostMapping("/nuevo")
    public ResponseEntity<DomicilioDto> crearDomicilio (@RequestBody DomicilioDto domicilio){
        return ResponseEntity.ok(service.guardar(domicilio));
    }

    //actualizar un domicilio
    @PutMapping("/actualizar")
    public ResponseEntity<DomicilioDto> actualizarDomicilio (@RequestBody DomicilioDto domicilio){
        if (domicilio.getId() != null){
            return ResponseEntity.ok(service.actualizar(domicilio));
        }else{
            return ResponseEntity.badRequest().body(domicilio);
        }
    }

    //borrar domicilio por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> BorrarDomicilioPorId(@PathVariable Integer id) {
        try {
            service.borrar(id);
        } catch (Exception e) {
            logger.debug(String.format("No se encuentra el domicilio con id %s", id));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(String.format("El domicilio %s fue eliminado", id));
    }
}