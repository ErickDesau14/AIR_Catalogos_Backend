package com.aidr.backend.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Cat-TiposNotificaciones")
public class CatTiposNotificacionesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idTipoNotificacion;

  private String tipoNotificacion;

  private int estatus;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaCreacion;

  @Temporal(TemporalType.DATE)
  private Date fechaModificacion;

  @Temporal(TemporalType.DATE)
  private Date fechaBaja;

}


