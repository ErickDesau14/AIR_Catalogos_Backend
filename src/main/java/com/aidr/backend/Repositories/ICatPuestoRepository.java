package com.aidr.backend.Repositories;

import com.aidr.backend.Models.CatPuestoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatPuestoRepository extends JpaRepository<CatPuestoEntity, Integer> {
    @Query(value = "SELECT COUNT(p) > 0 FROM CatPuestoEntity p WHERE REPLACE(LOWER(p.nombre), ' ', '') = REPLACE(LOWER(:nombre), ' ', '')")
    boolean existsByNombreIgnoreCase(@Param("nombre") String nombre);
}
