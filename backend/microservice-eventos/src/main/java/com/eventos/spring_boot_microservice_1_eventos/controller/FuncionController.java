package com.eventos.spring_boot_microservice_1_eventos.controller;

import com.eventos.spring_boot_microservice_1_eventos.model.Funcion;
import com.eventos.spring_boot_microservice_1_eventos.service.FuncionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @GetMapping("/listarFunciones")
    public List<Funcion> listarFunciones(){
        return funcionService.listarFunciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcion> obtenerFuncionPorId(@PathVariable Long id){
        Optional<Funcion> funcion =funcionService.obtenerFuncionPorId(id);
        return funcion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardarFuncion")
    public Funcion guardarFuncion(@RequestBody Funcion funcion){
        return funcionService.guardarFuncion(funcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFuncion(@PathVariable Long id){
        funcionService.eliminarFuncion(id);
        return ResponseEntity.noContent().build();
    }
}
