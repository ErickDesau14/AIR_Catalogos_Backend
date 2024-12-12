package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.CatExperienciaDTO;
import com.aidr.backend.DTOs.CatPuestoDTO;
import com.aidr.backend.Services.Implements.CatExperienciaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/e")
@CrossOrigin(
        origins = "http://localhost:8100/"
)
public class CatExperienciaController {

    @Autowired
    CatExperienciaServiceImpl catExperienciaService;

    @GetMapping("/experiencia")
    public List<CatExperienciaDTO> findExperiencia() {
        return catExperienciaService.findExperiencias();
    }

    @GetMapping("/experiencia/{id}")
    public ResponseEntity<CatExperienciaDTO> findExperienciaById(@PathVariable int id) {
        return new ResponseEntity<>(catExperienciaService.findExperienciaById(id), HttpStatus.OK);
    }

    @PostMapping("/experiencia")
    public ResponseEntity<?> createExperiencia(@RequestBody CatExperienciaDTO catExperienciaDTO) {
        try {
            CatExperienciaDTO newExperiencia = catExperienciaService.saveExperiencia(catExperienciaDTO);
            return new ResponseEntity<>(newExperiencia, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/experiencia/{id}/estatus/{estatus}")
    public ResponseEntity<CatExperienciaDTO> updateEstatus(
            @PathVariable int id,
            @PathVariable int estatus
    ) {
        return new ResponseEntity<>(catExperienciaService.updateEstatusExperiencia(id, estatus), HttpStatus.OK);
    }

    @PutMapping("/experiencia/{id}")
    public ResponseEntity<CatExperienciaDTO> updateExperiencia(
            @PathVariable int id,
            @RequestBody CatExperienciaDTO experienciaDTO
    ) {
        return new ResponseEntity<>(catExperienciaService.updateExperiencia(id, experienciaDTO), HttpStatus.OK);
    }

}
