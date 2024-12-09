package com.aidr.backend.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "NotificacionesXEmpresa")
public class NotificacionesEmpresaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idNotificacionXEmpresa;


  @ManyToOne
  @JoinColumn(name = "idTipoDeNotificacion", referencedColumnName = "idTipoNotificacion")
  private CatTiposnotificacionesEntity tipoNotificacion;

  @ManyToOne
  @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
  private EmpresaEntity empresa;

  @ManyToOne
  @JoinColumn(name = "idRecurso", referencedColumnName = "idRecurso")
  private RecursoEntity recurso;

  @ManyToOne
  @JoinColumn(name = "idSolicitudesOfertaXDemanda", referencedColumnName = "idSolicitudesOfertaXDemanda")
  private SolicitudesOfertaXDemanda solicitudesOfertaXDemanda;
}
