package com.eventos.spring_boot_microservice_1_eventos.controller;

import com.eventos.spring_boot_microservice_1_eventos.model.Teatro;
import com.eventos.spring_boot_microservice_1_eventos.repository.TeatroRepository;
import com.eventos.spring_boot_microservice_1_eventos.service.TeatroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teatros")
public class TeatroController {

    @Autowired
    private TeatroService teatroService;

    @GetMapping
    public List<Teatro> listarTeatros(){
        return teatroService.listarTeatros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teatro> obtenerTeatroPorId(@PathVariable Long id){
        Optional<Teatro> teatro = teatroService.obtenerTeatroPorId(id);
        return teatro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Teatro guardarTeatro(@RequestBody Teatro teatro){
        return teatroService.guardarTeatro(teatro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTeatro(@PathVariable Long id){
        teatroService.eliminarTeatro(id);
        return ResponseEntity.noContent().build();
    }
}
