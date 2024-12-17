package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.CatNotificacionDTO;
import com.aidr.backend.DTOs.CatPuestoDTO;
import com.aidr.backend.Models.CatNotificacionesEntity;
import com.aidr.backend.Repositories.ICatNotificacionesRepository;
import com.aidr.backend.Services.Interfaces.ICatNotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatNotificacionesServiceImpl implements ICatNotificacionesService {

  @Autowired
  private ICatNotificacionesRepository catNotificacionesRepository;

  @Override
  public List<CatNotificacionDTO> findNotificaciones() {
    return catNotificacionesRepository.findAll().stream()
            .map(notificacion -> CatNotificacionDTO.builder()
                    .idNotificacion(notificacion.getIdNotificacion())
                    .texto(notificacion.getTexto())
                    .estatus(notificacion.getEstatus())
                    .fechaCreacion(notificacion.getFechaCreacion())
                    .fechaModificacion(notificacion.getFechaModificacion())
                    .fechaBaja(notificacion.getFechaBaja())
                    .build())
            .collect(Collectors.toList());
  }

  @Override
  public CatNotificacionDTO findNotificacionById(int id) {
    CatNotificacionesEntity notificacion = catNotificacionesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));

    return CatNotificacionDTO.builder()
            .idNotificacion(notificacion.getIdNotificacion())
            .texto(notificacion.getTexto())
            .estatus(notificacion.getEstatus())
            .fechaCreacion(notificacion.getFechaCreacion())
            .fechaModificacion(notificacion.getFechaModificacion())
            .fechaBaja(notificacion.getFechaBaja())
            .build();
  }

  @Override
  public CatNotificacionDTO saveNotificacion(CatNotificacionDTO notificacionDTO) {

    String textoNormalizado = notificacionDTO.getTexto().trim().replaceAll("\\s+", " ").toLowerCase();

    if (catNotificacionesRepository.existsByTextoIgnoreCase(textoNormalizado)) {
      throw new RuntimeException("Ya existe esta notificacion");
    }

    CatNotificacionesEntity notificacion = new CatNotificacionesEntity();
    notificacion.setTexto(notificacionDTO.getTexto().trim());
    notificacion.setEstatus(1);
    notificacion.setFechaCreacion(new Date());

   notificacion = catNotificacionesRepository.save(notificacion);

    return CatNotificacionDTO.builder()
            .idNotificacion(notificacion.getIdNotificacion())
            .texto(notificacion.getTexto())
            .estatus(1)
            .fechaCreacion(notificacion.getFechaCreacion())
            .build();
  }

  @Override
  public CatNotificacionDTO updateNotificacion(int id, CatNotificacionDTO notificacionDTO) {
    CatNotificacionesEntity notificacion = catNotificacionesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Notificacion no encontrada"));

    String textoNormalizado = notificacionDTO.getTexto().trim().replaceAll("\\s+", " ").toLowerCase();

    boolean existeNotificacion = catNotificacionesRepository.findAll().stream()
            .anyMatch(p -> p.getIdNotificacion() != id && p.getTexto().trim().replaceAll("\\s+", " ").toLowerCase().equals(textoNormalizado));

    if (existeNotificacion) {
      throw new RuntimeException("Ya existe este puesto");
    }

    notificacion.setTexto(notificacionDTO.getTexto().trim());
    notificacion.setFechaModificacion(new Date());

    notificacion = catNotificacionesRepository.save(notificacion);

    return CatNotificacionDTO.builder()
            .idNotificacion(notificacion.getIdNotificacion())
            .texto(notificacion.getTexto())
            .estatus(notificacion.getEstatus())
            .fechaCreacion(notificacion.getFechaCreacion())
            .fechaModificacion(notificacion.getFechaModificacion())
            .fechaBaja(notificacion.getFechaBaja())
            .build();
  }

  @Override
  public CatNotificacionDTO updateEstatusNotificacion(int id, int estatus) {
    CatNotificacionesEntity notificacion = catNotificacionesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Notificacion no encontrada"));

    if (estatus == 0) {
      notificacion.setFechaBaja(new Date());
    } else {
      notificacion.setFechaBaja(null);
    }

    notificacion.setEstatus(estatus);
    notificacion = catNotificacionesRepository.save(notificacion);

    return CatNotificacionDTO.builder()
            .idNotificacion(notificacion.getIdNotificacion())
            .texto(notificacion.getTexto())
            .estatus(notificacion.getEstatus())
            .fechaCreacion(notificacion.getFechaCreacion())
            .fechaModificacion(notificacion.getFechaModificacion())
            .fechaBaja(notificacion.getFechaBaja())
            .build();
  }
}
