package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.EmpresaDTO;
import com.aidr.backend.DTOs.RecursoDTO;
import com.aidr.backend.Models.EmpresaEntity;
import com.aidr.backend.Models.RecursoEntity;
import com.aidr.backend.Repositories.IEmpresaRepository;
import com.aidr.backend.Repositories.IRecursoRepository;
import com.aidr.backend.Services.Interfaces.IRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoServiceImpl implements IRecursoService {

    @Autowired
    private IRecursoRepository recursoRepository;
    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public RecursoDTO createRecurso(RecursoDTO recursoDTO) {
        RecursoEntity recurso = RecursoEntity.builder()
                .idRecurso(recursoDTO.getIdRecurso())
                .nombre(recursoDTO.getNombre())
                .primerApellido(recursoDTO.getPrimerApellido())
                .segundoApellido(recursoDTO.getSegundoApellido())
                .tecnologias(recursoDTO.getTecnologias())
                .archivo(recursoDTO.getArchivo())
                .descripcion(recursoDTO.getDescripcion())
                .tarifa(recursoDTO.getTarifa())
                .empresa(recursoDTO.getEmpresa())
                .estatus(recursoDTO.isEstatus())
                .modalidad(recursoDTO.getModalidad())
                .experiencia(recursoDTO.getExperiencia())
                .puesto(recursoDTO.getPuesto())
                .ocultar(recursoDTO.isOcultar())
                .build();
        RecursoEntity recursoCreated = recursoRepository.save(recurso);
        recursoDTO.setIdRecurso(recursoCreated.getIdRecurso());
        EmpresaEntity empresaEntity = empresaRepository.findById(recursoCreated.getEmpresa().getIdEmpresa()).orElse(null);
        recursoDTO.setEmpresa(empresaEntity);
        return recursoDTO;
    }

    @Override
    public ResponseEntity<RecursoDTO> updateRecurso(Long idRecurso, RecursoDTO recursoDTO) {
        RecursoEntity recursoFound = recursoRepository.findById(idRecurso).orElse(null);
        recursoFound = RecursoEntity.builder()
                .idRecurso(recursoDTO.getIdRecurso())
                .nombre(recursoDTO.getNombre())
                .primerApellido(recursoDTO.getPrimerApellido())
                .segundoApellido(recursoDTO.getSegundoApellido())
                .tecnologias(recursoDTO.getTecnologias())
                .archivo(recursoDTO.getArchivo())
                .descripcion(recursoDTO.getDescripcion())
                .tarifa(recursoDTO.getTarifa())
                .empresa(recursoDTO.getEmpresa())
                .estatus(recursoDTO.isEstatus())
                .modalidad(recursoDTO.getModalidad())
                .experiencia(recursoDTO.getExperiencia())
                .puesto(recursoDTO.getPuesto())
                .ocultar(recursoDTO.isOcultar())
                .build();
        recursoRepository.save(recursoFound);
        return ResponseEntity.ok(recursoDTO);
    }

    @Override
    public ResponseEntity<RecursoDTO> updateRecursoOcultar(Long idRecurso, RecursoDTO recurso) {
        return null;
    }

    @Override
    public List<RecursoDTO> findRecursos(Pageable pageable) {
        return recursoRepository.findAll(pageable).stream()
                .map(recurso -> new RecursoDTO(
                        recurso.getIdRecurso(),
                        recurso.getNombre(),
                        recurso.getPrimerApellido(),
                        recurso.getSegundoApellido(),
                        recurso.getTecnologias(),
                        recurso.getArchivo(),
                        recurso.getDescripcion(),
                        recurso.getTarifa(),
                        recurso.getEmpresa(),
                        recurso.isEstatus(),
                        recurso.getModalidad(),
                        recurso.getExperiencia(),
                        recurso.getPuesto(),
                        recurso.isOcultar()
                )).collect(Collectors.toList());
    }

    @Override
    @Async
    public ResponseEntity<RecursoDTO> findRecursoById(Long idRecurso) {
        RecursoEntity recursoFound = recursoRepository.findById(idRecurso).orElse(null);
        RecursoDTO recursoDTO = RecursoDTO.builder()
                .idRecurso(recursoFound.getIdRecurso())
                .nombre(recursoFound.getNombre())
                .primerApellido(recursoFound.getPrimerApellido())
                .segundoApellido(recursoFound.getSegundoApellido())
                .tecnologias(recursoFound.getTecnologias())
                .archivo(recursoFound.getArchivo())
                .descripcion(recursoFound.getDescripcion())
                .tarifa(recursoFound.getTarifa())
                .empresa(recursoFound.getEmpresa())
                .estatus(recursoFound.isEstatus())
                .modalidad(recursoFound.getModalidad())
                .experiencia(recursoFound.getExperiencia())
                .puesto(recursoFound.getPuesto())
                .ocultar(recursoFound.isOcultar())
                .build();
        return ResponseEntity.ok(recursoDTO);
    }

    @Override
    @Async
    public void deleteRecursoById(Long idRecurso) {
        recursoRepository.deleteById(idRecurso);
    }

}
