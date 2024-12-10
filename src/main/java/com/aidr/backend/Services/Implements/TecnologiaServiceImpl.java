package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.TecnologiaDTO;
import com.aidr.backend.Models.TecnologiaEntity;
import com.aidr.backend.Repositories.ITecnologiaRepository;
import com.aidr.backend.Services.Interfaces.ITecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TecnologiaServiceImpl implements ITecnologiaService {

    @Autowired
    private ITecnologiaRepository tecnologiaRepository;

    @Override
    public List<TecnologiaDTO> findTecnologias() {
        return tecnologiaRepository.findAll().stream()
                .map(tecnologia -> TecnologiaDTO.builder()
                        .idTecnologia(tecnologia.getIdTecnologia())
                        .nombre(tecnologia.getNombre())
                        .estatus(tecnologia.getEstatus())
                        .fechaCreacion(tecnologia.getFechaCreacion())
                        .fechaModificacion(tecnologia.getFechaModificacion())
                        .fechaBaja(tecnologia.getFechaBaja())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TecnologiaDTO findTecnologiaById(Long id) {
        TecnologiaEntity tecnologia = tecnologiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tecnología no encontrada"));

        return TecnologiaDTO.builder()
                .idTecnologia(tecnologia.getIdTecnologia())
                .nombre(tecnologia.getNombre())
                .estatus(tecnologia.getEstatus())
                .fechaCreacion(tecnologia.getFechaCreacion())
                .fechaModificacion(tecnologia.getFechaModificacion())
                .fechaBaja(tecnologia.getFechaBaja())
                .build();
    }

    @Override
    public TecnologiaDTO saveTecnologia(TecnologiaDTO tecnologiaDTO) {
        TecnologiaEntity tecnologia = new TecnologiaEntity();
        tecnologia.setNombre(tecnologiaDTO.getNombre());
        tecnologia.setEstatus(1);
        tecnologia.setFechaCreacion(new Date());

        tecnologia = tecnologiaRepository.save(tecnologia);

        return TecnologiaDTO.builder()
                .idTecnologia(tecnologia.getIdTecnologia())
                .nombre(tecnologia.getNombre())
                .estatus(1)
                .fechaCreacion(tecnologia.getFechaCreacion())
                .build();
    }

    @Override
    public TecnologiaDTO updateTecnologia(Long id, TecnologiaDTO tecnologiaDTO) {
        TecnologiaEntity tecnologia = tecnologiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tecnología no encontrada"));

        tecnologia.setNombre(tecnologiaDTO.getNombre());
        tecnologia.setEstatus(tecnologiaDTO.getEstatus());
        tecnologia.setFechaModificacion(new Date());

        tecnologia = tecnologiaRepository.save(tecnologia);

        return TecnologiaDTO.builder()
                .idTecnologia(tecnologia.getIdTecnologia())
                .nombre(tecnologia.getNombre())
                .estatus(tecnologia.getEstatus())
                .fechaCreacion(tecnologia.getFechaCreacion())
                .fechaModificacion(tecnologia.getFechaModificacion())
                .fechaBaja(tecnologia.getFechaBaja())
                .build();
    }

    @Override
    public void deleteTecnologia(Long id) {
        TecnologiaEntity tecnologia = tecnologiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tecnología no encontrada"));

        tecnologia.setEstatus(0);
        tecnologia.setFechaBaja(new Date());

        tecnologiaRepository.save(tecnologia);
    }
}
