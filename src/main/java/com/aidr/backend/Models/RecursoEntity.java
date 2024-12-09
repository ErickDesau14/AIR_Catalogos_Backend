package com.aidr.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Recursos")
public class RecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idRecurso;

    @OneToMany(mappedBy = "recurso", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<EvaluacionEntity> evaluaciones;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "primer_apellido", length = 40, nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 40, nullable = false)
    private String segundoApellido;

    @ManyToMany(targetEntity = TecnologiaEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "recursos_tecnologias",
            joinColumns = @JoinColumn(name = "id_recurso"),
            inverseJoinColumns = @JoinColumn(name = "id_tecnologia"))
    private List<TecnologiaEntity> tecnologias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_archivo")
    private ArchivoEntity archivo;

    @Column(name = "descripcion", length = 120, nullable = false)
    private String descripcion;

    @Column(name = "tarifa", length = 120, nullable = false)
    private String tarifa;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaEntity empresa;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    @Column(name = "modalidad", length = 40, nullable = false)
    private String modalidad;

    @Column(name = "experiencia", length = 40, nullable = false)
    private String experiencia;

    @Column(name = "puesto", length = 120, nullable = false)
    private String puesto;

    @Column(name = "ocultar", nullable = false)
    private boolean ocultar;
}
