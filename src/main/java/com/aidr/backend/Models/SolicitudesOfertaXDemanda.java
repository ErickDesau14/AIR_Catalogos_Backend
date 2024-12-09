package com.aidr.backend.Models;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SolicitudOfertaXDemanda")
public class SolicitudesOfertaXDemanda {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idSolicitudesOfertaXDemanda;


  @ManyToOne
  @JoinColumn(name = "idSolicitudOferta", referencedColumnName = "idSolicitudOferta")
  private SolicitudOferta SolicitudOferta;


  @ManyToOne
  @JoinColumn(name = "idSolicitudDemanda", referencedColumnName = "idSolicitudDemanda")
  private SolicitudDemandaEntity SolicitudDemandaEntity;

}
