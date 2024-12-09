package com.aidr.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Evaluaciones")
public class EvaluacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluacion;

    @ManyToOne()
    @JoinColumn(name = "id_recurso")
    private RecursoEntity recurso;

    private int estrella1;

    private int estrella2;

    private int estrella3;

    private int estrella4;

    private int estrella5;

    private float promedio;

    private int totalEvaluaciones;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

}
