package com.aidr.backend.Repositories;

import com.aidr.backend.Models.SolicitudDemandaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitudDemandaRepository extends JpaRepository<SolicitudDemandaEntity, Long> {
}
