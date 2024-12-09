package com.aidr.backend.Services.Implements;

import com.aidr.backend.Models.NotificacionesEmpresaEntity;
import com.aidr.backend.Repositories.INotificacionesEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionesEmpresaServiceImpl {

  @Autowired
  INotificacionesEmpresaRepository INotificacionesEmpresaRepository;

  public List<NotificacionesEmpresaEntity> getAllNotificacionesEmpresa() {
    return INotificacionesEmpresaRepository.findAll();
  }

  public Optional<NotificacionesEmpresaEntity> getNotificacionEmpresaById(Long id) {
    return INotificacionesEmpresaRepository.findById(id);
  }

  public void saveOrUpdate(NotificacionesEmpresaEntity notificacionEmpresa) {
    INotificacionesEmpresaRepository.save(notificacionEmpresa);
  }

  public void delete(Long id) {
    INotificacionesEmpresaRepository.deleteById(id);
  }
}
