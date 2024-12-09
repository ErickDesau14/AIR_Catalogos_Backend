package com.aidr.backend.DTOs;

import com.aidr.backend.Models.ArchivoEntity;
import com.aidr.backend.Models.EmpresaEntity;
import com.aidr.backend.Models.TecnologiaEntity;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RecursoDTO implements Serializable {
    private Long idRecurso;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private List<TecnologiaEntity> tecnologias;
    private ArchivoEntity archivo;
    private String descripcion;
    private String tarifa;
    private EmpresaEntity empresa;
    private boolean estatus;
    private String modalidad;
    private String experiencia;
    private String puesto;
    private boolean ocultar;
}
