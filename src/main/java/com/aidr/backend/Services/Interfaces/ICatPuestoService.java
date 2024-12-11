package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.CatPuestoDTO;
import java.util.List;

public interface ICatPuestoService {

    List<CatPuestoDTO> findPuestos();
    CatPuestoDTO findPuestoById(int id);
    CatPuestoDTO savePuesto(CatPuestoDTO puestoDTO);
    CatPuestoDTO updatePuesto(int id, CatPuestoDTO puestoDTO);
    CatPuestoDTO updateEstatusPuesto(int id, int estatus);

}
