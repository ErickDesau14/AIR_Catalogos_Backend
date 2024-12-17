package com.aidr.backend.Repositories;

import com.aidr.backend.Models.CatTiposNotificacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatTiposNotificacionesRepository extends JpaRepository<CatTiposNotificacionesEntity, Integer> {
    @Query(value = "SELECT COUNT(tn) > 0 FROM CatTiposNotificacionesEntity tn WHERE REPLACE(LOWER(tn.tipoNotificacion), ' ', '') = REPLACE(LOWER(:tipoNotificacion), ' ', '')")
    boolean existsByTipoNotificacionIgnoreCase(@Param("tipoNotificacion") String tipoNotificacion);
}
