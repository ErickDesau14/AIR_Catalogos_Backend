package com.aidr.backend.Controllers;

import com.aidr.backend.Models.SolicitudDemandaEntity;
import com.aidr.backend.Services.Implements.SolicitudDemandaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/solicitudesdemanda")
@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
public class SolicitudDemandaController {

  @Autowired
  private SolicitudDemandaServiceImpl solicitudDemandaServiceImpl;

  @GetMapping
  public List<SolicitudDemandaEntity> getAll() {
    return solicitudDemandaServiceImpl.getSolicitudesDemanda();
  }

  @GetMapping("/{idSolicitudDemanda}")
  public Optional<SolicitudDemandaEntity> getById(@PathVariable("idSolicitudDemanda") long idSolicitudDemanda) {
    return solicitudDemandaServiceImpl.getSolicitudDemanda(idSolicitudDemanda);
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public SolicitudDemandaEntity saveUpdate(@RequestBody SolicitudDemandaEntity solicitudDemandaEntity) {
    solicitudDemandaServiceImpl.saveOrUpdate(solicitudDemandaEntity);
    return solicitudDemandaEntity;
  }

  @DeleteMapping("/{idSolicitudDemanda}")
  public void delete(@PathVariable("idSolicitudDemanda") long idSolicitudDemanda) {
    solicitudDemandaServiceImpl.delete(idSolicitudDemanda);
  }
}
