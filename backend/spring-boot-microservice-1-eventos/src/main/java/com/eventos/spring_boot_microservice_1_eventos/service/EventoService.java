package com.eventos.spring_boot_microservice_1_eventos.service;

import com.eventos.spring_boot_microservice_1_eventos.model.Evento;
import com.eventos.spring_boot_microservice_1_eventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> obtenerEventosPorTeatro(Long teatroId){
        return eventoRepository.findByTeatroId(teatroId);
    }

    public Optional<Evento> obtenerEventoPorId(Long id){
        return eventoRepository.findById(id);
    }

    public Evento guardarEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    public void eliminarEvento(Long id){
        eventoRepository.deleteById(id);
    }
}
