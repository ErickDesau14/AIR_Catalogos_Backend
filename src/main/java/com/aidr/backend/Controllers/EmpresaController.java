package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.EmpresaDTO;
import com.aidr.backend.Models.EmpresaEntity;
import com.aidr.backend.Services.Implements.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/e")
@CrossOrigin(origins = "http://localhost:8100/")
public class EmpresaController {

    @Autowired
    EmpresaServiceImpl empresaService;

    @PostMapping("/empresa")
    public EmpresaDTO createEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        return empresaService.createEmpresa(empresaDTO);
    }

    @GetMapping("/empresas")
    public List<EmpresaDTO> findEmpresas() {
        return empresaService.findEmpresas();
    }
}
