package com.aidr.backend.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatExperienciaDTO {
    private int idExperiencia;
    private int anho;
    private int estatus;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaBaja;
}
