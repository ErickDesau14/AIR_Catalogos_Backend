package com.aidr.backend.Services.Implements;

import com.aidr.backend.DTOs.EmpresaDTO;
import com.aidr.backend.Models.EmpresaEntity;
import com.aidr.backend.Repositories.IEmpresaRepository;
import com.aidr.backend.Services.Interfaces.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public EmpresaDTO createEmpresa(EmpresaDTO empresaDTO) {
        String passwordArchivo = generatePasswordArchivo();
        EmpresaEntity empresaEntity = EmpresaEntity.builder()
                .nombre(empresaDTO.getNombre())
                .contrasena(empresaDTO.getContrasena())
                .contrasenaArchivo(passwordArchivo)
                .estatus(empresaDTO.isEstatus())
                .build();
        empresaDTO.setContrasenaArchivo(passwordArchivo);
        empresaRepository.save(empresaEntity);
        return empresaDTO;
    }

    @Override
    public ResponseEntity<EmpresaDTO> findEmpresa(Long idEmpresa) {
        EmpresaEntity empresaFound = empresaRepository.findById(idEmpresa).orElse(null);
        EmpresaDTO empresaDTO = EmpresaDTO.builder()
                .idEmpresa(idEmpresa)
                .nombre(empresaFound.getNombre())
                .contrasenaArchivo(empresaFound.getContrasenaArchivo())
                .estatus(empresaFound.isEstatus())
                .build();
        return ResponseEntity.ok(empresaDTO);
    }

    @Override
    public List<EmpresaDTO> findEmpresas() {
        return empresaRepository.findAll().stream()
                .map(empresa -> new EmpresaDTO(
                        empresa.getIdEmpresa(),
                        empresa.getNombre(),
                        empresa.getContrasena(),
                        empresa.getContrasenaArchivo(),
                        empresa.isEstatus()
                )).collect(Collectors.toList());
    }

    @Override
    public String generatePasswordArchivo() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
