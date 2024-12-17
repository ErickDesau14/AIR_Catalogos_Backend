package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.CatTipoNotificacionDTO;

import java.util.List;

public interface ICatTipoNotificacionesService {

    List<CatTipoNotificacionDTO> findTipoNotificaciones();
    CatTipoNotificacionDTO findTipoNotificacionById(int id);
    CatTipoNotificacionDTO saveTipoNotificacion(CatTipoNotificacionDTO catTipoNotificacionDTO);
    CatTipoNotificacionDTO updateTipoNotificacion(int id, CatTipoNotificacionDTO catTipoNotificacionDTO);
    CatTipoNotificacionDTO updateEstatusTipoNotificacion(int id, int estatus);

}
