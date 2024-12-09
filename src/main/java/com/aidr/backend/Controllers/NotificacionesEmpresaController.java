package com.aidr.backend.Controllers;

import com.aidr.backend.Models.NotificacionesEmpresaEntity;
import com.aidr.backend.Services.Implements.NotificacionesEmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/notificaciones-empresa")
@CrossOrigin(origins = "http://localhost:8100", allowedHeaders = "*")
public class NotificacionesEmpresaController {

  @Autowired
  private NotificacionesEmpresaServiceImpl notificacionesEmpresaServiceImpl;

  @GetMapping
  public List<NotificacionesEmpresaEntity> getAll() {
    return notificacionesEmpresaServiceImpl.getAllNotificacionesEmpresa();
  }

  @GetMapping("/{idNotificacionXEmpresa}")
  public Optional<NotificacionesEmpresaEntity> getById(@PathVariable("idNotificacionXEmpresa") long idNotificacionXEmpresa) {
    return notificacionesEmpresaServiceImpl.getNotificacionEmpresaById(idNotificacionXEmpresa);
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public NotificacionesEmpresaEntity saveUpdate(@RequestBody NotificacionesEmpresaEntity notificacionEmpresa) {
    notificacionesEmpresaServiceImpl.saveOrUpdate(notificacionEmpresa);
    return notificacionEmpresa;
  }

  @DeleteMapping("/{idNotificacionXEmpresa}")
  public void delete(@PathVariable("idNotificacionXEmpresa") long idNotificacionXEmpresa) {
    notificacionesEmpresaServiceImpl.delete(idNotificacionXEmpresa);
  }

}
