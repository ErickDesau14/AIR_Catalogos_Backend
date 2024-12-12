package com.aidr.backend.Repositories;

import com.aidr.backend.Models.CatExperienciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatExperienciaRepository extends JpaRepository<CatExperienciaEntity, Integer> {
    @Query("SELECT COUNT(e) > 0 FROM CatExperienciaEntity e WHERE e.anho = :anhoDeExperiencia")
    boolean existsByAnhoDeExperiencia(@Param("anhoDeExperiencia") int anhoDeExperiencia);
}
