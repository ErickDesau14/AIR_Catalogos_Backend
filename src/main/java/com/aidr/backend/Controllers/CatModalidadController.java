package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.CatModalidadDTO;
import com.aidr.backend.Services.Implements.CatModalidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/m")
@CrossOrigin(
        origins = "http://localhost:8100/"
)
public class CatModalidadController {

    @Autowired
    CatModalidadServiceImpl catModalidadService;

    @GetMapping("/modalidad")
    public List<CatModalidadDTO> findModalidad() {
        return catModalidadService.findModalidad();
    }

    @GetMapping("/modalidad/{id}")
    public ResponseEntity<CatModalidadDTO> findModalidadById(@PathVariable int id) {
        return new ResponseEntity<>(catModalidadService.findModalidadById(id), HttpStatus.OK);
    }

    @PostMapping("/modalidad")
    public ResponseEntity<?> createModalidad(@RequestBody CatModalidadDTO catModalidadDTO) {
        try {
            CatModalidadDTO newModalidad = catModalidadService.saveModalidad(catModalidadDTO);
            return new ResponseEntity<>(newModalidad, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modalidad/{id}/estatus/{estatus}")
    public ResponseEntity<CatModalidadDTO> updateEstatus(
            @PathVariable int id,
            @PathVariable int estatus
    ) {
        return new ResponseEntity<>(catModalidadService.updateEstatusModalidad(id, estatus), HttpStatus.OK);
    }

    @PutMapping("/modalidad/{id}")
    public ResponseEntity<CatModalidadDTO> updateModalidad(
            @PathVariable int id,
            @RequestBody CatModalidadDTO catModalidadDTO
    ) {
        return  new ResponseEntity<>(catModalidadService.updateModalidad(id, catModalidadDTO), HttpStatus.OK);
    }

}
