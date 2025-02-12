package com.eventos.spring_boot_microservice_1_eventos.controller;

import com.eventos.spring_boot_microservice_1_eventos.model.Ciudad;
import com.eventos.spring_boot_microservice_1_eventos.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CiudadController {

    @Autowired
    public CiudadService ciudadService;

    @GetMapping
    public List<Ciudad> listarCiudades(){
        return ciudadService.listarCiudades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerCiudadPorId(@PathVariable Long id){
        Optional<Ciudad> ciudad = ciudadService.obtenerCiudadPorId(id);
        return ciudad.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ciudad guardarCiudad(@RequestBody Ciudad ciudad){
        return ciudadService.guardarCiudad(ciudad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCiudad(@PathVariable Long id){
        ciudadService.eliminarCiudad(id);
        return ResponseEntity.noContent().build();
    }
}
