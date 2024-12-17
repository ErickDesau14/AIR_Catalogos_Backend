package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.CatNotificacionDTO;
import com.aidr.backend.Services.Implements.CatNotificacionesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/n")
@CrossOrigin(origins = "http://localhost:8100")
public class CatNotificacionesController {

  @Autowired
  private CatNotificacionesServiceImpl catNotificacionesServiceImpl;

  @GetMapping("/notificacion")
  public List<CatNotificacionDTO> findNotificaciones() {
    return catNotificacionesServiceImpl.findNotificaciones();
  }

  @GetMapping("/notificacion/{id}")
  public ResponseEntity<CatNotificacionDTO> findNotificacionById(@PathVariable int id) {
    return new ResponseEntity<>(catNotificacionesServiceImpl.findNotificacionById(id), HttpStatus.OK);
  }

  @PostMapping("/notificacion")
  public ResponseEntity<?> createNotificacion(@RequestBody CatNotificacionDTO notificacionDTO) {
    try {
      CatNotificacionDTO newNotificacion = catNotificacionesServiceImpl.saveNotificacion(notificacionDTO);
      return new ResponseEntity<>(newNotificacion, HttpStatus.CREATED);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/notificacion/{id}/estatus/{estatus}")
  public ResponseEntity<CatNotificacionDTO> updateEstatus(
          @PathVariable int id,
          @PathVariable int estatus
  ) {
    return new ResponseEntity<>(catNotificacionesServiceImpl.updateEstatusNotificacion(id, estatus), HttpStatus.OK);
  }

  @PutMapping("/notificacion/{id}")
  public ResponseEntity<CatNotificacionDTO> updateNotificacion(
          @PathVariable int id,
          @RequestBody CatNotificacionDTO notificacionDTO
  ) {
    return new ResponseEntity<>(catNotificacionesServiceImpl.updateNotificacion(id, notificacionDTO), HttpStatus.OK);
  }

}
