package com.aidr.backend.Services.Implements;

import com.aidr.backend.Models.SolicitudDemandaEntity;
import com.aidr.backend.Repositories.ISolicitudDemandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class SolicitudDemandaServiceImpl {

  @Autowired
  ISolicitudDemandaRepository ISolicitudDemandaRepository;

  public List<SolicitudDemandaEntity> getSolicitudesDemanda() {
    return ISolicitudDemandaRepository.findAll();
  }

  public Optional<SolicitudDemandaEntity> getSolicitudDemanda(Long id) {
    return ISolicitudDemandaRepository.findById(id);
  }

  public void saveOrUpdate(SolicitudDemandaEntity solicitudDemandaEntity) {
    ISolicitudDemandaRepository.save(solicitudDemandaEntity);
  }

  public void delete(Long id) {
    ISolicitudDemandaRepository.deleteById(id);
  }


}
