package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.CatTipoNotificacionDTO;
import com.aidr.backend.Models.CatTiposNotificacionesEntity;
import com.aidr.backend.Repositories.ICatTiposNotificacionesRepository;
import com.aidr.backend.Services.Interfaces.ICatTipoNotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatTiposNotificacionesServiceImpl implements ICatTipoNotificacionesService {

    @Autowired
    private ICatTiposNotificacionesRepository iCatTiposnotificacionesRepository;

    @Override
    public List<CatTipoNotificacionDTO> findTipoNotificaciones() {
        return iCatTiposnotificacionesRepository.findAll().stream()
                .map(tipoNotificacion -> CatTipoNotificacionDTO.builder()
                        .idTipoNotificacion(tipoNotificacion.getIdTipoNotificacion())
                        .tipoNotificacion(tipoNotificacion.getTipoNotificacion())
                        .estatus(tipoNotificacion.getEstatus())
                        .fechaCreacion(tipoNotificacion.getFechaCreacion())
                        .fechaModificacion(tipoNotificacion.getFechaModificacion())
                        .fechaBaja(tipoNotificacion.getFechaBaja())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CatTipoNotificacionDTO findTipoNotificacionById(int id) {
        CatTiposNotificacionesEntity tipoNotificacion = iCatTiposnotificacionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tpo de notificación no encontrada"));

        return CatTipoNotificacionDTO.builder()
                .idTipoNotificacion(tipoNotificacion.getIdTipoNotificacion())
                .tipoNotificacion(tipoNotificacion.getTipoNotificacion())
                .estatus(tipoNotificacion.getEstatus())
                .fechaCreacion(tipoNotificacion.getFechaCreacion())
                .fechaModificacion(tipoNotificacion.getFechaModificacion())
                .fechaBaja(tipoNotificacion.getFechaBaja())
                .build();
    }

    @Override
    public CatTipoNotificacionDTO saveTipoNotificacion(CatTipoNotificacionDTO tipoNotificacionDTO) {

        String textoNormalizado = tipoNotificacionDTO.getTipoNotificacion().trim().replaceAll("\\s+", " ").toLowerCase();

        if (iCatTiposnotificacionesRepository.existsByTipoNotificacionIgnoreCase(textoNormalizado)) {
            throw new RuntimeException("Ya existe este tipo de notificacion");
        }

        CatTiposNotificacionesEntity tipoNotificacion = new CatTiposNotificacionesEntity();
        tipoNotificacion.setTipoNotificacion(tipoNotificacionDTO.getTipoNotificacion().trim());
        tipoNotificacion.setEstatus(1);
        tipoNotificacion.setFechaCreacion(new Date());

        tipoNotificacion = iCatTiposnotificacionesRepository.save(tipoNotificacion);

        return CatTipoNotificacionDTO.builder()
                .idTipoNotificacion(tipoNotificacion.getIdTipoNotificacion())
                .tipoNotificacion(tipoNotificacion.getTipoNotificacion())
                .estatus(1)
                .fechaCreacion(tipoNotificacion.getFechaCreacion())
                .build();
    }

    @Override
    public CatTipoNotificacionDTO updateTipoNotificacion(int id, CatTipoNotificacionDTO tipoNotificacionDTO) {
        CatTiposNotificacionesEntity tipoNotificacion = iCatTiposnotificacionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificacion no encontrada"));

        String textoNormalizado = tipoNotificacionDTO.getTipoNotificacion().trim().replaceAll("\\s+", " ").toLowerCase();

        boolean existeTipoNotificacion = iCatTiposnotificacionesRepository.findAll().stream()
                .anyMatch(p -> p.getIdTipoNotificacion() != id && p.getTipoNotificacion().trim().replaceAll("\\s+", " ").toLowerCase().equals(textoNormalizado));

        if (existeTipoNotificacion) {
            throw new RuntimeException("Ya existe este tipo de notificacion");
        }

        tipoNotificacion.setTipoNotificacion(tipoNotificacionDTO.getTipoNotificacion().trim());
        tipoNotificacion.setFechaModificacion(new Date());

        tipoNotificacion = iCatTiposnotificacionesRepository.save(tipoNotificacion);

        return CatTipoNotificacionDTO.builder()
                .idTipoNotificacion(tipoNotificacion.getIdTipoNotificacion())
                .tipoNotificacion(tipoNotificacion.getTipoNotificacion())
                .estatus(tipoNotificacion.getEstatus())
                .fechaCreacion(tipoNotificacion.getFechaCreacion())
                .fechaModificacion(tipoNotificacion.getFechaModificacion())
                .fechaBaja(tipoNotificacion.getFechaBaja())
                .build();
    }

    @Override
    public CatTipoNotificacionDTO updateEstatusTipoNotificacion(int id, int estatus) {
        CatTiposNotificacionesEntity tipoNotificacion = iCatTiposnotificacionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de notificacion no encontrada"));

        if (estatus == 0) {
            tipoNotificacion.setFechaBaja(new Date());
        } else {
            tipoNotificacion.setFechaBaja(null);
        }

        tipoNotificacion.setEstatus(estatus);
        tipoNotificacion = iCatTiposnotificacionesRepository.save(tipoNotificacion);

        return CatTipoNotificacionDTO.builder()
                .idTipoNotificacion(tipoNotificacion.getIdTipoNotificacion())
                .tipoNotificacion(tipoNotificacion.getTipoNotificacion())
                .estatus(tipoNotificacion.getEstatus())
                .fechaCreacion(tipoNotificacion.getFechaCreacion())
                .fechaModificacion(tipoNotificacion.getFechaModificacion())
                .fechaBaja(tipoNotificacion.getFechaBaja())
                .build();
    }

}

