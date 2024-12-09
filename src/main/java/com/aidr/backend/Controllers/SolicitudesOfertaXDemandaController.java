package com.aidr.backend.Controllers;

import com.aidr.backend.Models.SolicitudesOfertaXDemanda;
import com.aidr.backend.Services.Implements.SolicitudesOfertaXDemandaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/solicitudes-oferta-demanda")
@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
public class SolicitudesOfertaXDemandaController {

  @Autowired
  private SolicitudesOfertaXDemandaServiceImpl solicitudesOfertaXDemandaServiceImpl;

  @GetMapping
  public List<SolicitudesOfertaXDemanda> getAll() {
    return solicitudesOfertaXDemandaServiceImpl.getAllSolicitudesOfertaXDemanda();
  }

  @GetMapping("/{idSolicitudesOfertaXDemanda}")
  public Optional<SolicitudesOfertaXDemanda> getById(@PathVariable("idSolicitudesOfertaXDemanda") long idSolicitudesOfertaXDemanda) {
    return solicitudesOfertaXDemandaServiceImpl.getSolicitudOfertaXDemandaById(idSolicitudesOfertaXDemanda);
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public SolicitudesOfertaXDemanda saveUpdate(@RequestBody SolicitudesOfertaXDemanda solicitudesOfertaXDemanda) {
    solicitudesOfertaXDemandaServiceImpl.saveOrUpdate(solicitudesOfertaXDemanda);
    return solicitudesOfertaXDemanda;
  }

  @DeleteMapping("/{idSolicitudesOfertaXDemanda}")
  public void delete(@PathVariable("idSolicitudesOfertaXDemanda") long idSolicitudesOfertaXDemanda) {
    solicitudesOfertaXDemandaServiceImpl.delete(idSolicitudesOfertaXDemanda);
  }
}
