package com.aidr.backend.DTOs;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TecnologiaDTO implements Serializable {
    private Long idTecnologia;
    private String nombre;
    private boolean estatus;

}
