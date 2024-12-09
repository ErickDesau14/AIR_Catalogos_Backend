package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.EmpresaDTO;
import com.aidr.backend.Models.EmpresaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IEmpresaService {

    public EmpresaDTO createEmpresa(EmpresaDTO empresaDTO);
    public ResponseEntity<EmpresaDTO> findEmpresa(Long idEmpresa);
    public List<EmpresaDTO> findEmpresas();
    public String generatePasswordArchivo();

}
