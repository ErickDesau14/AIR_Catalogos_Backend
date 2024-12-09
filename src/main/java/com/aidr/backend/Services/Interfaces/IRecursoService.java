package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.RecursoDTO;
import com.aidr.backend.Models.RecursoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IRecursoService {

    public RecursoDTO createRecurso(RecursoDTO recursoDTO);

    public ResponseEntity<RecursoDTO> updateRecurso(Long idRecurso, RecursoDTO recurso);

    public List<RecursoDTO> findRecursos(Pageable pageable);

    public ResponseEntity<RecursoDTO> findRecursoById(Long idRecurso);

    public void deleteRecursoById(Long idRecurso);

    public ResponseEntity<RecursoDTO> updateRecursoOcultar(Long idRecurso, RecursoDTO recurso);

}
