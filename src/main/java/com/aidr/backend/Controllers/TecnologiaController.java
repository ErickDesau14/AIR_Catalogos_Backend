package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.TecnologiaDTO;
import com.aidr.backend.Models.TecnologiaEntity;
import com.aidr.backend.Services.Implements.TecnologiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/t")
@CrossOrigin(
        origins = "http://localhost:8100/"
)
public class TecnologiaController {

    @Autowired
    TecnologiaServiceImpl tecnologiaService;

    @GetMapping("/tecnologias")
    public List<TecnologiaDTO> finTecnologias() {
        return tecnologiaService.findTecnologias();
    }

    @GetMapping("/tecnologias/{id}")
    public ResponseEntity<TecnologiaDTO> findTecnologiaById(@PathVariable int id) {
        return new ResponseEntity<>(tecnologiaService.findTecnologiaById(id), HttpStatus.OK);
    }

    @PostMapping("/tecnologias")
    public ResponseEntity<?> createTecnologia(@RequestBody TecnologiaDTO tecnologiaDTO) {
        try {
            TecnologiaDTO newTecnologia = tecnologiaService.saveTecnologia(tecnologiaDTO);
            return new ResponseEntity<>(newTecnologia, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/tecnologias/{id}/estatus/{estatus}")
    public ResponseEntity<TecnologiaDTO> updateEstatus(
            @PathVariable int id,
            @PathVariable int estatus
    ) {
        return new ResponseEntity<>(tecnologiaService.updateEstatusTecnologia(id, estatus), HttpStatus.OK);
    }

    @PutMapping("/tecnologias/{id}")
    public ResponseEntity<TecnologiaDTO> updateTecnologia(
            @PathVariable int id,
            @RequestBody TecnologiaDTO tecnologiaDTO
    ) {
        return new ResponseEntity<>(tecnologiaService.updateTecnologia(id, tecnologiaDTO), HttpStatus.OK);
    }

}
