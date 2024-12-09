package com.aidr.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Empresas")
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "contrasena", length = 100, nullable = false)
    private String contrasena;

    @Column(name = "contrasena_archivo", length = 100, nullable = false)
    private String contrasenaArchivo;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    private String razonSocial;

    private String domicilio;

    private String repsocFolio;

    private String repsocPDF;

    private String numeroContacto;

    private String bitacora;

    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private Set<RecursoEntity> recursos;

}
