package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.CatPuestoDTO;
import com.aidr.backend.Models.CatPuestoEntity;
import com.aidr.backend.Repositories.ICatPuestoRepository;
import com.aidr.backend.Services.Interfaces.ICatPuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatPuestoServiceImpl implements ICatPuestoService {

    @Autowired
    private ICatPuestoRepository catPuestoRepository;

    @Override
    public List<CatPuestoDTO> findPuestos() {
        return catPuestoRepository.findAll().stream()
                .map(puesto -> CatPuestoDTO.builder()
                        .idPuesto(puesto.getIdPuesto())
                        .nombre(puesto.getNombre())
                        .estatus(puesto.getEstatus())
                        .fechaCreacion(puesto.getFechaCreacion())
                        .fechaModificacion(puesto.getFechaModificacion())
                        .fechaBaja(puesto.getFechaBaja())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CatPuestoDTO findPuestoById(int id) {
        CatPuestoEntity puesto = catPuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        return CatPuestoDTO.builder()
                .idPuesto(puesto.getIdPuesto())
                .nombre(puesto.getNombre())
                .estatus(puesto.getEstatus())
                .fechaCreacion(puesto.getFechaCreacion())
                .fechaModificacion(puesto.getFechaModificacion())
                .fechaBaja(puesto.getFechaBaja())
                .build();
    }

    @Override
    public CatPuestoDTO savePuesto(CatPuestoDTO puestoDTO) {

        String nombreNormalizado = puestoDTO.getNombre().trim().replaceAll("\\s+", " ").toLowerCase();

        if (catPuestoRepository.existsByNombreIgnoreCase(nombreNormalizado)) {
            throw new RuntimeException("Ya existe este puesto");
        }

        CatPuestoEntity puesto = new CatPuestoEntity();
        puesto.setNombre(puestoDTO.getNombre().trim());
        puesto.setEstatus(1);
        puesto.setFechaCreacion(new Date());

        puesto = catPuestoRepository.save(puesto);

        return CatPuestoDTO.builder()
                .idPuesto(puesto.getIdPuesto())
                .nombre(puesto.getNombre())
                .estatus(1)
                .fechaCreacion(puesto.getFechaCreacion())
                .build();
    }

    @Override
    public CatPuestoDTO updatePuesto(int id, CatPuestoDTO puestoDTO) {
        CatPuestoEntity puesto = catPuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        String nombreNormalizado = puestoDTO.getNombre().trim().replaceAll("\\s+", " ").toLowerCase();

        boolean existePuesto = catPuestoRepository.findAll().stream()
                .anyMatch(p -> p.getIdPuesto() != id && p.getNombre().trim().replaceAll("\\s+", " ").toLowerCase().equals(nombreNormalizado));

        if (existePuesto) {
            throw new RuntimeException("Ya existe este puesto");
        }

        puesto.setNombre(puestoDTO.getNombre().trim());
        puesto.setFechaModificacion(new Date());

        puesto = catPuestoRepository.save(puesto);

        return CatPuestoDTO.builder()
                .idPuesto(puesto.getIdPuesto())
                .nombre(puesto.getNombre())
                .estatus(puesto.getEstatus())
                .fechaCreacion(puesto.getFechaCreacion())
                .fechaModificacion(puesto.getFechaModificacion())
                .fechaBaja(puesto.getFechaBaja())
                .build();
    }

    @Override
    public CatPuestoDTO updateEstatusPuesto(int id, int estatus) {
        CatPuestoEntity puesto = catPuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        if (estatus == 0) {
            puesto.setFechaBaja(new Date());
        } else {
            puesto.setFechaBaja(null);
        }

        puesto.setEstatus(estatus);
        puesto = catPuestoRepository.save(puesto);

        return CatPuestoDTO.builder()
                .idPuesto(puesto.getIdPuesto())
                .nombre(puesto.getNombre())
                .estatus(puesto.getEstatus())
                .fechaCreacion(puesto.getFechaCreacion())
                .fechaModificacion(puesto.getFechaModificacion())
                .fechaBaja(puesto.getFechaBaja())
                .build();
    }

}
