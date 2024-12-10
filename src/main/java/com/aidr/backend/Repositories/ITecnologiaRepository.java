package com.aidr.backend.Repositories;

import com.aidr.backend.Models.TecnologiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnologiaRepository extends JpaRepository<TecnologiaEntity, Integer> {
    @Query(value = "SELECT COUNT(t) > 0 FROM TecnologiaEntity t WHERE REPLACE(LOWER(t.nombre), ' ', '') = REPLACE(LOWER(:nombre), ' ', '')")
    boolean existsByNombreIgnoreCase(@Param("nombre") String nombre);
}
