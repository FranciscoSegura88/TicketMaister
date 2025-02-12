package com.eventos.spring_boot_microservice_1_eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

}
