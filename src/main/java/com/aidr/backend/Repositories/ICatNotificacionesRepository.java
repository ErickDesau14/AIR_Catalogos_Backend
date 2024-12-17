package com.aidr.backend.Repositories;

import com.aidr.backend.Models.CatNotificacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatNotificacionesRepository extends JpaRepository<CatNotificacionesEntity, Integer> {
    @Query(value = "SELECT COUNT(n) > 0 FROM CatNotificacionesEntity n WHERE REPLACE(LOWER(n.texto), ' ', '') = REPLACE(LOWER(:texto), ' ', '')")
    boolean existsByTextoIgnoreCase(@Param("texto") String texto);
}
