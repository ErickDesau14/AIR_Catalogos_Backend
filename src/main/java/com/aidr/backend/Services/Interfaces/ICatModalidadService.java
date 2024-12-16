package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.CatModalidadDTO;

import java.util.List;

public interface ICatModalidadService {

    List<CatModalidadDTO> findModalidad();
    CatModalidadDTO findModalidadById(int id);
    CatModalidadDTO saveModalidad(CatModalidadDTO catModalidadDTO);
    CatModalidadDTO updateModalidad(int id, CatModalidadDTO catModalidadDTO);
    CatModalidadDTO updateEstatusModalidad(int id, int estatus);

}
