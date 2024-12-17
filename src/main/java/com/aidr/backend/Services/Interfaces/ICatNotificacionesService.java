package com.aidr.backend.Services.Interfaces;

import com.aidr.backend.DTOs.CatNotificacionDTO;

import java.util.List;

public interface ICatNotificacionesService {

    List<CatNotificacionDTO> findNotificaciones();
    CatNotificacionDTO findNotificacionById(int id);
    CatNotificacionDTO saveNotificacion(CatNotificacionDTO catNotificacionDTO);
    CatNotificacionDTO updateNotificacion(int id, CatNotificacionDTO catNotificacionDTO);
    CatNotificacionDTO updateEstatusNotificacion(int id, int estatus);

}
