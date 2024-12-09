package com.aidr.backend.Repositories;

import com.aidr.backend.Models.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecursoRepository extends JpaRepository<RecursoEntity, Long> {
}
