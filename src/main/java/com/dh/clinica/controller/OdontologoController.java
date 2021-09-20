package com.dh.clinica.controller;

import com.dh.clinica.dto.OdontologoDto;
import com.dh.clinica.service.IServiceOdontologo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private IServiceOdontologo service;
    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    //buscar y mostrar todos los odontologos
    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDto>> buscarTodosLosOdontologos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    //buscar un odontologo por id
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDto> buscarOdontologoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    //agregar un nuevo odontologo
    @PostMapping("/nuevo")
    public ResponseEntity<OdontologoDto> crearOdontologo (@RequestBody OdontologoDto odontologo){
        return ResponseEntity.ok(service.guardar(odontologo));
    }

    //actualizar un odontologo
    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizarOdontologo (@RequestBody OdontologoDto odontologo){
        if (odontologo.getId() != null && buscarOdontologoPorId(odontologo.getId())!=null){
            logger.debug(String.format("Se actualizó correctamente el odontologo con id %s", odontologo.getId()));
            return ResponseEntity.ok(service.actualizar(odontologo));
        }else{
            logger.debug(String.format("No se encuentra el odontologo con id %s", odontologo.getId()));
            return ResponseEntity.badRequest().body(odontologo);
        }
    }

    //borrar un odontologo por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarOdontologoPorId(@PathVariable Integer id) {
        try {
            service.borrar(id);
        } catch (Exception e) {
            logger.debug(String.format("No se encuentra el odontologo con id %s", id));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(String.format("El odontologo con id %s fue eliminado", id));
    }
}