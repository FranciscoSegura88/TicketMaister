package com.eventos.spring_boot_microservice_1_eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String estado;
    private String pais;

    @OneToMany(mappedBy = "ciudad", cascade=CascadeType.ALL)
    private List<Teatro> teatros;
}
