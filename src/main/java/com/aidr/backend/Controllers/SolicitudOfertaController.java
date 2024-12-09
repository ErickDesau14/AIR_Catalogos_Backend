package com.aidr.backend.Controllers;

import com.aidr.backend.Models.SolicitudOferta;
import com.aidr.backend.Services.Implements.SolicitudOfertaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/solicitud_oferta")
@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
public class SolicitudOfertaController {

  @Autowired
  private SolicitudOfertaServiceImpl solicitudOfertaServiceImpl;

  @GetMapping
  public List<SolicitudOferta> getAll() {
    return solicitudOfertaServiceImpl.getSolicitudesOferta();
  }

  @GetMapping("/{idSolicitudOferta}")
  public Optional<SolicitudOferta> getById(@PathVariable("idSolicitudOferta") long idSolicitudOferta) {
    return solicitudOfertaServiceImpl.getSolicitudOferta(idSolicitudOferta);
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public SolicitudOferta saveUpdate(@RequestBody SolicitudOferta solicitudOferta) {
    solicitudOfertaServiceImpl.saveOrUpdate(solicitudOferta);
    return solicitudOferta;
  }

  @DeleteMapping("/{idSolicitudOferta}")
  public void delete(@PathVariable("idSolicitudOferta") long idSolicitudOferta) {
    solicitudOfertaServiceImpl.delete(idSolicitudOferta);
  }
}
