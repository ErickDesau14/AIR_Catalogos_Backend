package com.aidr.backend.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ExperienciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idExperiencia;

    private String experiencia;

    private boolean estatus;

}
