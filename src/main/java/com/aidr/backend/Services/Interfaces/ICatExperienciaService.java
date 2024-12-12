package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.CatExperienciaDTO;

import java.util.List;

public interface ICatExperienciaService {

    List<CatExperienciaDTO> findExperiencias();
    CatExperienciaDTO findExperienciaById(int id);
    CatExperienciaDTO saveExperiencia(CatExperienciaDTO catExperienciaDTO);
    CatExperienciaDTO updateExperiencia(int id, CatExperienciaDTO catExperienciaDTO);
    CatExperienciaDTO updateEstatusExperiencia(int id, int estatus);

}
