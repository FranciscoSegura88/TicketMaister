package com.eventos.spring_boot_microservice_1_eventos.repository;

import com.eventos.spring_boot_microservice_1_eventos.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
