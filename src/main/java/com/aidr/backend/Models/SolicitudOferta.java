package com.aidr.backend.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "SolicitudOferta")
public class SolicitudOferta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSolicitudOferta;


  @ManyToOne
  @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
  private EmpresaEntity empresa;


  @ManyToOne
  @JoinColumn(name = "idRecurso", referencedColumnName = "idRecurso")
  private RecursoEntity recurso;

  private LocalDate fecha;
}
