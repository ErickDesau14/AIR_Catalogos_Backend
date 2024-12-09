package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.RecursoDTO;
import com.aidr.backend.Services.Implements.RecursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("api/v1/r")
@CrossOrigin(origins = "http://localhost:8100/")
public class RecursoController {

    @Autowired
    RecursoServiceImpl recursoService;

    @PostMapping(value = "/recurso")
    public RecursoDTO createRecurso(@RequestBody RecursoDTO recursoDTO) {
        return recursoService.createRecurso(recursoDTO);
    }

    @PutMapping(value = "/recurso/{idRecurso}")
    public ResponseEntity<RecursoDTO> updateRecurso(@PathVariable(name = "idRecurso") Long idRecurso, @RequestBody RecursoDTO recursoDTO) {
        return recursoService.updateRecurso(idRecurso, recursoDTO);
    }

    @GetMapping("/recursos")
    public List<RecursoDTO> findRecursos(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return recursoService.findRecursos(pageable);
    }

    @GetMapping("/recurso/{idRecurso}")
    public ResponseEntity<RecursoDTO> findRecursoById(@PathVariable(name = "idRecurso") Long idRecurso) {
        return recursoService.findRecursoById(idRecurso);
    }

    @DeleteMapping("/recurso/{idRecurso}")
    public void deleteRecursoById(@PathVariable(name = "idRecurso") Long idRecurso) {
        recursoService.deleteRecursoById(idRecurso);
    }

}
