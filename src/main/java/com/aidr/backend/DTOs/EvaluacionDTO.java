package com.aidr.backend.DTOs;

import com.aidr.backend.Models.RecursoEntity;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EvaluacionDTO implements Serializable {
     private Long idEvaluacion;
     private RecursoEntity recurso;
     private int estrella1;
     private int estrella2;
     private int estrella3;
     private int estrella4;
     private int estrella5;
     private float promedio;
     private int totalEvaluaciones;
     private boolean estatus = true;
}
