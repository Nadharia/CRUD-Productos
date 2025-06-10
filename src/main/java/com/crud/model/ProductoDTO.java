package com.crud.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {

    @NotBlank(message = "El nombre debe estar")
    @Size(max = 30)
    private String nombre;
    @NotBlank(message = "La descripción debe estar")
    private String descripcion;
    @NotNull(message = "El precio debe estar")
    @Positive(message = "El precio debe ser positivo")
    private Double precio;
    @NotNull(message = "El stock debe estar")
    @Positive(message = "El stock debe ser positivo")
    private Integer stock;

    public Producto toEntity(){
        return new Producto(null, this.nombre, this.descripcion, this.precio, this.stock);
    }
}
