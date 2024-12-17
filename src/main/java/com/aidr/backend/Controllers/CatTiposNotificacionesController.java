package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.CatTipoNotificacionDTO;
import com.aidr.backend.Services.Implements.CatTiposNotificacionesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/tn")
@CrossOrigin(origins = "http://localhost:8100")
public class CatTiposNotificacionesController {

  @Autowired
  private CatTiposNotificacionesServiceImpl catTiposnotificacionesServiceImpl;

  @GetMapping("/tipoNotificacion")
  public List<CatTipoNotificacionDTO> findTipoNotificaciones() {
    return catTiposnotificacionesServiceImpl.findTipoNotificaciones();
  }

  @GetMapping("/tipoNotificacion/{id}")
  public ResponseEntity<CatTipoNotificacionDTO> getTipoNotificacionById(@PathVariable int id) {
    return new ResponseEntity<>(catTiposnotificacionesServiceImpl.findTipoNotificacionById(id), HttpStatus.OK);
  }

  @PostMapping("/tipoNotificacion")
  public ResponseEntity<?> createTipoNotificacion(@RequestBody CatTipoNotificacionDTO tipoNotificacionDTO) {
    try {
      CatTipoNotificacionDTO newTipoNotificacion = catTiposnotificacionesServiceImpl.saveTipoNotificacion(tipoNotificacionDTO);
      return new ResponseEntity<>(newTipoNotificacion, HttpStatus.CREATED);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/tipoNotificacion/{id}/estatus/{estatus}")
  public ResponseEntity<CatTipoNotificacionDTO> updateEstatus(
          @PathVariable int id,
          @PathVariable int estatus
  ) {
    return new ResponseEntity<>(catTiposnotificacionesServiceImpl.updateEstatusTipoNotificacion(id, estatus), HttpStatus.OK);
  }

  @PutMapping("/tipoNotificacion/{id}")
  public ResponseEntity<CatTipoNotificacionDTO> updateTipoNotificacion(
          @PathVariable int id,
          @RequestBody CatTipoNotificacionDTO tipoNotificacionDTO
  ) {
    return new ResponseEntity<>(catTiposnotificacionesServiceImpl.updateTipoNotificacion(id, tipoNotificacionDTO), HttpStatus.OK);
  }
}

