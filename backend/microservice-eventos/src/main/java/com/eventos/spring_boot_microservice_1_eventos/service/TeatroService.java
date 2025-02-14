package com.eventos.spring_boot_microservice_1_eventos.service;

import com.eventos.spring_boot_microservice_1_eventos.model.Teatro;
import com.eventos.spring_boot_microservice_1_eventos.repository.TeatroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeatroService {

    @Autowired
    private TeatroRepository teatroRepository;

    public List<Teatro> listarTeatros(){
        return teatroRepository.findAll();
    }

    public Optional<Teatro> obtenerTeatroPorId(Long id){
        return teatroRepository.findById(id);
    }

    public Teatro guardarTeatro(Teatro teatro){
        return teatroRepository.save(teatro);
    }

    public void eliminarTeatro(Long id){
        teatroRepository.deleteById(id);
    }
}
