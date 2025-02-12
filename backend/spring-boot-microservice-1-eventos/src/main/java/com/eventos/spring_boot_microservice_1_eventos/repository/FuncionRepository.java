package com.eventos.spring_boot_microservice_1_eventos.repository;

import com.eventos.spring_boot_microservice_1_eventos.model.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {
    List<Funcion> findByEventoId(Long eventoId);
}
