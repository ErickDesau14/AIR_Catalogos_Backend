package com.aidr.backend.DTOs;

import com.aidr.backend.Models.RecursoEntity;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArchivoDTO implements Serializable {
    private Long idArchivo;
    private String nombre;
    private byte[] archivo;
    private boolean estatus;
}
