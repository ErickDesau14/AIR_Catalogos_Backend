package com.aidr.backend.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SolicitudDemanda")
public class SolicitudDemandaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSolicitudDemanda;


  @ManyToOne
  @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
  private EmpresaEntity empresa;

  @ManyToOne
  @JoinColumn(name = "idRecurso", referencedColumnName = "idRecurso")
  private RecursoEntity recurso;

  private String fecha;

  private double tarifaPropuesta;

  private String modalidad;

  private String fechaInicio;

  private String fechaTermino;

  private String horaInicio;

  private String horaFin;

  private int estatus;
}
