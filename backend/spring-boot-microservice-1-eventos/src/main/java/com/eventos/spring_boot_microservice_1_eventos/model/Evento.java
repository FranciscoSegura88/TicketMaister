package com.eventos.spring_boot_microservice_1_eventos.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "teatro_id", nullable = false)
    private Teatro teatro;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Funcion> funciones;
}
