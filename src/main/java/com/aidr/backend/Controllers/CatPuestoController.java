package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.CatPuestoDTO;
import com.aidr.backend.Services.Implements.CatPuestoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/p")
@CrossOrigin(
        origins = "http://localhost:8100/"
)

public class CatPuestoController {

    @Autowired
    CatPuestoServiceImpl catPuestoService;

    @GetMapping("/puestos")
    public List<CatPuestoDTO> finPuestos() {
        return catPuestoService.findPuestos();
    }

    @GetMapping("/puestos/{id}")
    public ResponseEntity<CatPuestoDTO> findPuestoById(@PathVariable int id) {
        return new ResponseEntity<>(catPuestoService.findPuestoById(id), HttpStatus.OK);
    }

    @PostMapping("/puestos")
    public ResponseEntity<?> createPuesto(@RequestBody CatPuestoDTO puestoDTO) {
        try {
            CatPuestoDTO newPuesto = catPuestoService.savePuesto(puestoDTO);
            return new ResponseEntity<>(newPuesto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/puestos/{id}/estatus/{estatus}")
    public ResponseEntity<CatPuestoDTO> updateEstatus(
            @PathVariable int id,
            @PathVariable int estatus
    ) {
        return new ResponseEntity<>(catPuestoService.updateEstatusPuesto(id, estatus), HttpStatus.OK);
    }

    @PutMapping("/puestos/{id}")
    public ResponseEntity<CatPuestoDTO> updatePuesto(
            @PathVariable int id,
            @RequestBody CatPuestoDTO puestoDTO
    ) {
        return new ResponseEntity<>(catPuestoService.updatePuesto(id, puestoDTO), HttpStatus.OK);
    }

}
