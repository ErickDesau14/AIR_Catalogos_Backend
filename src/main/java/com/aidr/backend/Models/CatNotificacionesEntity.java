package com.aidr.backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "CAT-Notificaciones")
public class CatNotificacionesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idNotificacion;

  @ManyToOne
  @JoinColumn(name = "idTipoDeNotificacion", referencedColumnName = "idTipoNotificacion")
  private CatTiposNotificacionesEntity tipoNotificacion;

  private String texto;

  private int estatus;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaCreacion;

  @Temporal(TemporalType.DATE)
  private Date fechaModificacion;

  @Temporal(TemporalType.DATE)
  private Date fechaBaja;

}

