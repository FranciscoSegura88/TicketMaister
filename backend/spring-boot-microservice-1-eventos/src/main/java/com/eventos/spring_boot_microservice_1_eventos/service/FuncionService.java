package com.eventos.spring_boot_microservice_1_eventos.service;

import com.eventos.spring_boot_microservice_1_eventos.model.Funcion;
import com.eventos.spring_boot_microservice_1_eventos.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    public List<Funcion> listarFunciones(){
        return funcionRepository.findAll();
    }

    public Optional<Funcion> obtenerFuncionPorId(Long id){
        return funcionRepository.findById(id);
    }

    public Funcion guardarFuncion(Funcion funcion){
        return funcionRepository.save(funcion);
    }

    public void eliminarFuncion(Long id){
        funcionRepository.deleteById(id);
    }
}
