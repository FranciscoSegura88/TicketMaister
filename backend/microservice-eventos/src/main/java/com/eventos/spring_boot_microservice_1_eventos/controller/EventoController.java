package com.eventos.spring_boot_microservice_1_eventos.controller;

import com.eventos.spring_boot_microservice_1_eventos.model.Evento;
import com.eventos.spring_boot_microservice_1_eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private final EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @GetMapping("/teatro/{teatroId}")
    public List<Evento> obtenerEventosPorTeatro(@PathVariable Long teatroId){
        return eventoService.obtenerEventosPorTeatro(teatroId);
    }

    @PostMapping("/crearEvento")
    public Evento crearEvento(@RequestBody Evento evento){
        return eventoService.guardarEvento(evento);
    }

    @DeleteMapping("/eliminarEvento/{id}")
    public void eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
    }
}
