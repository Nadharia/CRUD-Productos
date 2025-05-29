package com.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre debe estar")
    private String nombre;

    @NotBlank(message = "La descripción debe estar")
    private String descripcion;

    @NotNull(message = "El precio debe estar")
    @Positive(message = "El precio debe ser positivo")
    private Double precio;

    @NotNull(message = "El stock debe estar")
    @Positive(message = "El stock debe ser positivo")
    private Integer stock;
}
