package com.aidr.backend.Repositories;

import com.aidr.backend.Models.SolicitudOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitudOfertaRepository extends JpaRepository<SolicitudOferta, Long> {
}
