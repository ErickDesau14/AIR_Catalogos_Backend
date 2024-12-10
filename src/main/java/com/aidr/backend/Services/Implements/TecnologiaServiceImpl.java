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
    public TecnologiaDTO findTecnologiaById(int id) {
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

        String nombreNormalizado = tecnologiaDTO.getNombre().trim().replaceAll("\\s+", " ").toLowerCase();

        if(tecnologiaRepository.existsByNombreIgnoreCase(nombreNormalizado)) {
            throw new RuntimeException("Ya existe una tecnología con ese nombre");
        }

        TecnologiaEntity tecnologia = new TecnologiaEntity();
        tecnologia.setNombre(tecnologiaDTO.getNombre().trim());
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
    public TecnologiaDTO updateTecnologia(int id, TecnologiaDTO tecnologiaDTO) {
        TecnologiaEntity tecnologia = tecnologiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tecnología no encontrada"));

        String nombreNormalizado = tecnologiaDTO.getNombre().trim().replaceAll("\\s+", " ").toLowerCase();

        boolean existeTecnologia = tecnologiaRepository.findAll().stream()
                .anyMatch(t -> t.getIdTecnologia() != id && t.getNombre().trim().replaceAll("\\s+", " ").toLowerCase().equals(nombreNormalizado));

        if(existeTecnologia) {
            throw new RuntimeException("Ya existe una tecnología con ese nombre");
        }

        tecnologia.setNombre(tecnologiaDTO.getNombre().trim());
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
    public TecnologiaDTO updateEstatusTecnologia(int id, int estatus) {
        TecnologiaEntity tecnologia = tecnologiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tecnología no encontrada"));

        if (estatus == 0) {
            tecnologia.setFechaBaja(new Date());
        } else {
            tecnologia.setFechaBaja(null);
        }

        tecnologia.setEstatus(estatus);
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
}
