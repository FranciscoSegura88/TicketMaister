package com.eventos.spring_boot_microservice_1_eventos.service;

import com.eventos.spring_boot_microservice_1_eventos.model.Ciudad;
import com.eventos.spring_boot_microservice_1_eventos.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> listarCiudades(){
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> obtenerCiudadPorId(Long id){
        return ciudadRepository.findById(id);
    }

    public Ciudad guardarCiudad(Ciudad ciudad){
        return ciudadRepository.save(ciudad);
    }

    public void eliminarCiudad(Long id){
        ciudadRepository.deleteById(id);
    }
}
