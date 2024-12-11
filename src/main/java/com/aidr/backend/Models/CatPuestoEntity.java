package com.aidr.backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "puestos")
public class CatPuestoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPuesto;

    private String nombre;

    private int estatus;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

}
