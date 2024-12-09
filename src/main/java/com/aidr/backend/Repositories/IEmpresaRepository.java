package com.aidr.backend.Repositories;

import com.aidr.backend.Models.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
