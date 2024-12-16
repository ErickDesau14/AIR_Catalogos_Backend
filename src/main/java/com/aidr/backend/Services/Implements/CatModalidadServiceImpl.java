package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.CatModalidadDTO;
import com.aidr.backend.Models.CatModalidadEntity;
import com.aidr.backend.Repositories.ICatModalidadRepository;
import com.aidr.backend.Services.Interfaces.ICatModalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatModalidadServiceImpl implements ICatModalidadService {

    @Autowired
    private ICatModalidadRepository catModalidadRepository;

    @Override
    public List<CatModalidadDTO> findModalidad() {
        return catModalidadRepository.findAll().stream()
                .map(modalidad -> CatModalidadDTO.builder()
                        .idModalidad(modalidad.getIdModalidad())
                        .nombre(modalidad.getNombre())
                        .estatus(modalidad.getEstatus())
                        .fechaCreacion(modalidad.getFechaCreacion())
                        .fechaModificacion(modalidad.getFechaModificacion())
                        .fechaBaja(modalidad.getFechaBaja())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CatModalidadDTO findModalidadById(int id) {
        CatModalidadEntity modalidad = catModalidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modalidad no encontrada"));

        return CatModalidadDTO.builder()
                .idModalidad(modalidad.getIdModalidad())
                .nombre(modalidad.getNombre())
                .estatus(modalidad.getEstatus())
                .fechaCreacion(modalidad.getFechaCreacion())
                .fechaModificacion(modalidad.getFechaModificacion())
                .fechaBaja(modalidad.getFechaBaja())
                .build();
    }

    @Override
    public CatModalidadDTO saveModalidad(CatModalidadDTO modalidadDTO) {

        String nombreNormalizado = modalidadDTO.getNombre().trim().replaceAll("\\s+", " ").toLowerCase();

        if (catModalidadRepository.existsByNombreIgnoreCase(nombreNormalizado)) {
            throw new RuntimeException("Ya existe una modalidad con ese nombre");
        }

        CatModalidadEntity modalidad = new CatModalidadEntity();
        modalidad.setNombre(modalidadDTO.getNombre().trim());
        modalidad.setEstatus(1);
        modalidad.setFechaCreacion(new Date());

        modalidad = catModalidadRepository.save(modalidad);

        return CatModalidadDTO.builder()
                .idModalidad(modalidad.getIdModalidad())
                .nombre(modalidad.getNombre())
                .estatus(1)
                .fechaCreacion(modalidad.getFechaCreacion())
                .build();
    }

    @Override
    public CatModalidadDTO updateModalidad(int id, CatModalidadDTO catModalidadDTO) {
        CatModalidadEntity modalidad = catModalidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modalidad no encontrada"));

        String nombreNormalizado = catModalidadDTO.getNombre().trim().replaceAll("\\s+", " ").toLowerCase();

        boolean existeModalidad = catModalidadRepository.findAll().stream()
                .anyMatch(t -> t.getIdModalidad() != id && t.getNombre().trim().replaceAll("\\s+", " ").toLowerCase().equals(nombreNormalizado));

        if(existeModalidad) {
            throw new RuntimeException("Ya existe una tecnología con ese nombre");
        }

        modalidad.setNombre(catModalidadDTO.getNombre().trim());
        modalidad.setFechaModificacion(new Date());

        modalidad = catModalidadRepository.save(modalidad);

        return CatModalidadDTO.builder()
                .idModalidad(modalidad.getIdModalidad())
                .nombre(modalidad.getNombre())
                .estatus(modalidad.getEstatus())
                .fechaCreacion(modalidad.getFechaCreacion())
                .fechaModificacion(modalidad.getFechaModificacion())
                .fechaBaja(modalidad.getFechaBaja())
                .build();
    }

    @Override
    public CatModalidadDTO updateEstatusModalidad(int id, int estatus) {
        CatModalidadEntity modalidad = catModalidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modalidad no encontrada"));

        if (estatus == 0) {
            modalidad.setFechaBaja(new Date());
        } else {
            modalidad.setFechaBaja(null);
        }

        modalidad.setEstatus(estatus);
        modalidad = catModalidadRepository.save(modalidad);

        return CatModalidadDTO.builder()
                .idModalidad(modalidad.getIdModalidad())
                .nombre(modalidad.getNombre())
                .estatus(modalidad.getEstatus())
                .fechaCreacion(modalidad.getFechaCreacion())
                .fechaModificacion(modalidad.getFechaModificacion())
                .fechaBaja(modalidad.getFechaBaja())
                .build();
    }

}
