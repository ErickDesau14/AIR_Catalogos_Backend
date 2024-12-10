package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.TecnologiaDTO;
import java.util.List;

public interface ITecnologiaService {

    List<TecnologiaDTO> findTecnologias();
    TecnologiaDTO findTecnologiaById(int id);
    TecnologiaDTO saveTecnologia(TecnologiaDTO tecnologiaDTO);
    TecnologiaDTO updateTecnologia(int id, TecnologiaDTO tecnologiaDTO);
    TecnologiaDTO updateEstatusTecnologia(int id, int estatus);

}
