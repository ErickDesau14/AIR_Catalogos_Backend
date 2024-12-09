package com.aidr.backend.DTOs;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmpresaDTO implements Serializable {
    private Long idEmpresa;
    private String nombre;
    private String contrasena;
    private String contrasenaArchivo;
    private boolean estatus;
}
