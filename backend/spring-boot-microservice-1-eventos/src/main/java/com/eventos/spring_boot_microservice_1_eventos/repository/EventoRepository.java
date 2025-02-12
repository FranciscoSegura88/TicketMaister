package com.eventos.spring_boot_microservice_1_eventos.repository;

import com.eventos.spring_boot_microservice_1_eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByTeatroId(Long teatroId);
}
