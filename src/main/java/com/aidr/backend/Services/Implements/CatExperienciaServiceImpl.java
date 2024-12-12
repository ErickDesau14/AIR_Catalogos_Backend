package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.CatExperienciaDTO;
import com.aidr.backend.Models.CatExperienciaEntity;
import com.aidr.backend.Repositories.ICatExperienciaRepository;
import com.aidr.backend.Services.Interfaces.ICatExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatExperienciaServiceImpl implements ICatExperienciaService {

    @Autowired
    private ICatExperienciaRepository catExperienciaRepository;

    @Override
    public List<CatExperienciaDTO> findExperiencias() {
        return catExperienciaRepository.findAll().stream()
                .map(experiencia -> CatExperienciaDTO.builder()
                        .idExperiencia(experiencia.getIdExperiencia())
                        .anho(experiencia.getAnho())
                        .estatus(experiencia.getEstatus())
                        .fechaCreacion(experiencia.getFechaCreacion())
                        .fechaModificacion(experiencia.getFechaModificacion())
                        .fechaBaja(experiencia.getFechaBaja())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CatExperienciaDTO findExperienciaById(int id) {
        CatExperienciaEntity experiencia = catExperienciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experiencia no encontrada"));

        return CatExperienciaDTO.builder()
                .idExperiencia(experiencia.getIdExperiencia())
                .anho(experiencia.getAnho())
                .estatus(experiencia.getEstatus())
                .fechaCreacion(experiencia.getFechaCreacion())
                .fechaModificacion(experiencia.getFechaModificacion())
                .fechaBaja(experiencia.getFechaBaja())
                .build();
    }

    @Override
    public CatExperienciaDTO saveExperiencia(CatExperienciaDTO experienciaDTO) {
        if (catExperienciaRepository.existsByAnhoDeExperiencia(experienciaDTO.getAnho())) {
            throw new RuntimeException("Ya existe este año de experiencia");
        }

        CatExperienciaEntity experiencia = new CatExperienciaEntity();
        experiencia.setAnho(experienciaDTO.getAnho());
        experiencia.setEstatus(1);
        experiencia.setFechaCreacion(new Date());

        experiencia = catExperienciaRepository.save(experiencia);

        return CatExperienciaDTO.builder()
                .idExperiencia(experiencia.getIdExperiencia())
                .anho(experiencia.getAnho())
                .estatus(experiencia.getEstatus())
                .fechaCreacion(experiencia.getFechaCreacion())
                .build();
    }

    @Override
    public CatExperienciaDTO updateExperiencia(int id, CatExperienciaDTO experienciaDTO) {
        CatExperienciaEntity experiencia = catExperienciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experiencia no encontrada"));

        if (experienciaDTO.getAnho() <= 0) {
            throw new RuntimeException("Los años de experiencia deben ser mayores a 0");
        }

        boolean existeAnhoDeExperiencia = catExperienciaRepository.findAll().stream()
                .anyMatch(e -> e.getIdExperiencia() != id &&
                        e.getAnho() == experienciaDTO.getAnho());

        if (existeAnhoDeExperiencia) {
            throw new RuntimeException("Ya existe este año de experiencia");
        }

        experiencia.setAnho(experienciaDTO.getAnho());
        experiencia.setFechaModificacion(new Date());

        experiencia = catExperienciaRepository.save(experiencia);

        return CatExperienciaDTO.builder()
                .idExperiencia(experiencia.getIdExperiencia())
                .anho(experiencia.getAnho())
                .estatus(experiencia.getEstatus())
                .fechaCreacion(experiencia.getFechaCreacion())
                .fechaModificacion(experiencia.getFechaModificacion())
                .fechaBaja(experiencia.getFechaBaja())
                .build();
    }

    @Override
    public CatExperienciaDTO updateEstatusExperiencia(int id, int estatus) {

        CatExperienciaEntity experiencia = catExperienciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experiencia no encontrada"));

        experiencia.setEstatus(estatus);

        if (estatus == 0) {
            experiencia.setFechaBaja(new Date());
        } else {
            experiencia.setFechaBaja(null);
        }

        catExperienciaRepository.save(experiencia);

        return CatExperienciaDTO.builder()
                .idExperiencia(experiencia.getIdExperiencia())
                .anho(experiencia.getAnho())
                .estatus(experiencia.getEstatus())
                .fechaCreacion(experiencia.getFechaCreacion())
                .fechaModificacion(experiencia.getFechaModificacion())
                .fechaBaja(experiencia.getFechaBaja())
                .build();
    }

}
