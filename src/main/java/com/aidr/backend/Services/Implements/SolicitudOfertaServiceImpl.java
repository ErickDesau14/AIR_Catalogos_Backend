package com.aidr.backend.Services.Implements;

import com.aidr.backend.Models.SolicitudOferta;
import com.aidr.backend.Repositories.ISolicitudOfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudOfertaServiceImpl {

  @Autowired
  ISolicitudOfertaRepository ISolicitudOfertaRepository;

  public List<SolicitudOferta> getSolicitudesOferta() {
    return ISolicitudOfertaRepository.findAll();
  }

  public Optional<SolicitudOferta> getSolicitudOferta(Long id) {
    return ISolicitudOfertaRepository.findById(id);
  }

  public void saveOrUpdate(SolicitudOferta solicitudOferta) {
    ISolicitudOfertaRepository.save(solicitudOferta);
  }

  public void delete(Long id) {
    ISolicitudOfertaRepository.deleteById(id);
  }
}

