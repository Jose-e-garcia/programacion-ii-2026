package com.estudiante.semana13bibliotecaapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "libro")
public class Libro {

    private Long id;
    private String codigo;
    private String titulo;
    private String autor;
    private String categoria;
    private Integer anioPublicacion;
    private BigDecimal precio;
    private Boolean disponible;

}