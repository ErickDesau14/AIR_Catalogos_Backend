package com.aidr.backend.Services.Implements;

import com.aidr.backend.Models.SolicitudesOfertaXDemanda;
import com.aidr.backend.Repositories.ISolicitudesOfertaXDemandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudesOfertaXDemandaServiceImpl {

  @Autowired
  ISolicitudesOfertaXDemandaRepository ISolicitudesOfertaXDemandaRepository;

  public List<SolicitudesOfertaXDemanda> getAllSolicitudesOfertaXDemanda() {
    return ISolicitudesOfertaXDemandaRepository.findAll();
  }

  public Optional<SolicitudesOfertaXDemanda> getSolicitudOfertaXDemandaById(Long id) {
    return ISolicitudesOfertaXDemandaRepository.findById(id);
  }

  public void saveOrUpdate(SolicitudesOfertaXDemanda solicitudesOfertaXDemanda) {
    ISolicitudesOfertaXDemandaRepository.save(solicitudesOfertaXDemanda);
  }

  public void delete(Long id) {
    ISolicitudesOfertaXDemandaRepository.deleteById(id);
  }
}
