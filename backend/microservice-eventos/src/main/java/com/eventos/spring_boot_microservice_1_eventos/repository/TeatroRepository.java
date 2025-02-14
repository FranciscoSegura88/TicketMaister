package com.eventos.spring_boot_microservice_1_eventos.repository;

import com.eventos.spring_boot_microservice_1_eventos.model.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeatroRepository extends JpaRepository<Teatro, Long> {
    @Query("SELECT t FROM Teatro t WHERE t.ciudad.id = :ciudadId")
    List<Teatro> findByCiudadId(@Param("ciudadId") Long ciudadId);
}
