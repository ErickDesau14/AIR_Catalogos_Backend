package com.aidr.backend.Repositories;

import com.aidr.backend.Models.CatModalidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatModalidadRepository extends JpaRepository<CatModalidadEntity, Integer> {
    @Query(value = "SELECT COUNT(m) > 0 FROM CatModalidadEntity m WHERE REPLACE(LOWER(m.nombre), ' ', '') = REPLACE(LOWER(:nombre), ' ', '')")
    boolean existsByNombreIgnoreCase(@Param("nombre") String nombre);
}
